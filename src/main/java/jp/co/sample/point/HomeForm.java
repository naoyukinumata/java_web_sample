package jp.co.sample.point;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class HomeForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message="Point‚ª‹ó‚¾‚¼")
	@NumberFormat( style = Style.NUMBER)
	@Min(1)
	@Max(100)
	private Integer point;

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

}
// @NotEmpty(message="Point‚ª‹ó‚¾‚¼")
// @Size(min=1, max=10, message="’·‚³‚Í1‚©‚ç10‚¾‚¼")
// private String name;
//
// @Email
// private String email
//

