package testGround;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class TestGroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestGroundApplication.class, args);
	}
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("sign", "Whaddup!");
		return "helloWorld.jsp";
	}
}
