package jp.co.sample.point;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/point")
public class PointController {

	@RequestMapping
	public String index(@ModelAttribute @Valid HomeForm form,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			for (ObjectError error : errorList) {
				System.out.println(error.getDefaultMessage());
			}
			System.out.println("POINT CONTROLLER ERROR");
			return "home";
		}
		model.addAttribute("point", form.getPoint());
		return "point";
	}
}
