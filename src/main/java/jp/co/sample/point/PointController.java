package jp.co.sample.point;

import java.util.List;

import javax.validation.Valid;

import jp.co.sample.dao.PointDao;
import jp.co.sample.dao.PointHistoryDao;
import jp.co.sample.model.Point;
import jp.co.sample.model.PointHistory;

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

		// ポイント付与、ポイント履歴登録処理
		Integer user_id = form.getUser_id();
		Point point = new PointDao().selectByUserId(form.getUser_id());
		if (point != null) {
			new PointDao().update(user_id, user_id, form.getPoint());
			point = new PointDao().selectByUserId(user_id);
		} else {
			new PointDao().insert(user_id, user_id, form.getPoint());
			point = new PointDao().selectByUserId(user_id);
		}
		new PointHistoryDao().insert(user_id, user_id, form.getPoint());

		model.addAttribute("point", form.getPoint());
		model.addAttribute("afterPoint", point.getPoint());
		model.addAttribute("pointHistoryList", new PointHistoryDao().selectByUserId(user_id));
		return "point";
	}
}
