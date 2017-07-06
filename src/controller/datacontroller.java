package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class datacontroller {

	
    @RequestMapping("/spring.do")
    public String test()
    {
        String str = "this is a SpringMVC instance!";
        return "index.html";
    }

    @RequestMapping("/login.do")
    public ModelAndView check(HttpServletRequest request)
    {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        //调用业务处理LoginCheck
      /*  if(LoginCheck.check(name, password))*/
        if(true)
        {
            return new ModelAndView("success","username",name);
        }
        return new ModelAndView("index.html","username",name);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/empd.do")
	public JSONObject getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		Map map = new HashMap();
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);
		map.put("int", new Integer(1));
		map.put("arr", new String[] { "a", "b" });
		map.put("func", "function(i){ return this.arr[i]; }");
		JSONObject json = JSONObject.fromObject(map);
		 
		System.out.println(json);
		
		response.getWriter().print(json);       //或者写response.getWriter().print(result);
		response.getWriter().flush();
		response.getWriter().close();
		
		return null;
	}
	
	
}
