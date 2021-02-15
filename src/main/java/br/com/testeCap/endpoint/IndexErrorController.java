package br.com.testeCap.endpoint;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class IndexErrorController implements ErrorController{
    private final static String PATH = "/error";
    @Override
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        
    	// rota para caso ocorra algum erro
        return "Ocorreu um erro nesta requisição";
    }

}
