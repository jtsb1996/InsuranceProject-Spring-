package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.cart.CartClass;
import com.example.demo.cart.CartController;
import com.example.demo.condition.ConditionController;
import com.example.demo.insurance.InsuranceClass;
import com.example.demo.insurance.InsuranceController;
import com.example.demo.user.UserClass;
import com.example.demo.user.UserController;

@Controller
public class homeController {
	@Autowired
	CartController cartController;
	@Autowired
	InsuranceController insuranceController;
	@Autowired
	UserController userController;
	@Autowired
	ConditionController conditionController;
	// using of HttpServletRequest to get values from url
	/*@RequestMapping("homeView")
	public String home(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		session.setAttribute("name", name);
		return "homeView";
	}*/
		
	//using of session to get values from url
	/*@RequestMapping("homeView")
	public String home(String name, HttpSession sess) {
		sess.setAttribute("name", name);
		return "homeView";
	}*/
	
	// using of session to get multiple values from url
	/*@RequestMapping("homeView")
	public String home(@RequestParam("name")String myName, HttpSession session) {
		session.setAttribute("name", myName);
		return "homeView";
	}*/
	
	@RequestMapping("homeView")
	public ModelAndView home(@RequestParam("firstName")String myName) {
		ModelAndView mv = new ModelAndView();
		List<String> typeList = insuranceController.getUniqueType();
		List<String> companyList = insuranceController.getUniqueCompany();
		List<String> conditionNameList = conditionController.getUniqueConditionName();
		//adding of data
		mv.addObject("name", myName);
		mv.addObject("typelist", typeList);
		mv.addObject("companylist", companyList);
		mv.addObject("conditionNameList", conditionNameList);
		// setting of view
		mv.setViewName("homeView");
		return mv;
	}

	@RequestMapping("displayInsurance")
	public ModelAndView displayInsurance(@RequestParam("name")String name) {
		ModelAndView mv = new ModelAndView("insuranceView");
		List<InsuranceClass> list = insuranceController.getInsurance();
		mv.addObject("list", list);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("displayInsuranceBy")
	public ModelAndView displayInsurance(@RequestParam("type")String type, @RequestParam("company")String company, 
			@RequestParam(value = "conditionName", required=false)String conditionName , @RequestParam("age")String age, @RequestParam("name")String name) {
		ModelAndView mv = new ModelAndView("insuranceView");
		List<InsuranceClass> temp = insuranceController.getInsuranceByAll(type, company, age,conditionName);
		mv.addObject("list", temp);
		mv.addObject("name", name);
		return mv;		
	}
	
	@RequestMapping("insuranceCart")
	public ModelAndView displayInsuranceCart(@RequestParam("name")String myName) {
		ModelAndView mv = new ModelAndView("insuranceCartView");
		UserClass user = userController.getUserByName(myName);
		List<CartClass> cartList = cartController.getCartByUserId(user.getuID());
		System.out.println(cartList);
		mv.addObject("name", myName);
		mv.addObject("cart", cartList);
		return mv;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
