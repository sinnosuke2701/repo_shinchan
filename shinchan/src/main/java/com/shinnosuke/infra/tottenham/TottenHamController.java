package com.shinnosuke.infra.tottenham;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TottenHamController {
	
	@RequestMapping(value = "/xdm/v1/infra/tottenham/TottenHamXdm")
		public String TottenHamXdm() {
		
		return "/xdm/v1/infra/tottenham/TottenHamXdm";
	}
	
}
