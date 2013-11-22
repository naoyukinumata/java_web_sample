package jp.co.sample.point;

import java.util.Date;
import java.util.List;

import jp.co.sample.dao.UserDao;
import jp.co.sample.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sample")
public class HomeController {

	@RequestMapping
	public String index(Model model) {
		return home(model);
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute(new HomeForm());
		Date date = new Date();
		model.addAttribute("date", date);

		UserDao dao = new UserDao();
		List<User> list = dao.all();
		model.addAttribute("userList", list);
		return "home";
	}
	@RequestMapping(value = "skip", method = RequestMethod.GET)
	public String skip(Model model) {
		System.out.println("SKIP ACTION");
		return "redirect:home";
	}
	
}