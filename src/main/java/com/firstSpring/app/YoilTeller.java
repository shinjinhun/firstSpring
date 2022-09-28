package com.firstSpring.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@Controller
public class YoilTeller {
    @RequestMapping("/getYoil") // http://localhost:8090/app/getYoil?year=2021&month=10&day=1
    public String main(int year, int month, int day, Model model) throws IOException {
//        String year = request.getParameter("year");
//        String month = request.getParameter("month");
//        String day = request.getParameter("day");

//        int yyyy = Integer.parseInt(year);
//        int mm = Integer.parseInt(month);
//        int dd = Integer.parseInt(day);

        if(!isValid(year, month, day))
            return "yoilError";


        // 2. 처리
        char yoil = getYoil(year, month, day);

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);

        return "yoil";

//        // 3. 출력
////        System.out.println(year + "년 " + month + "월 " + day + "일은 ");
////        System.out.println(yoil + "요일입니다.");
//        response.setContentType("text/html");    // 응답의 형식을 html로 지정
//        response.setCharacterEncoding("utf-8");  // 응답의 인코딩을 utf-8로 지정
//        PrintWriter out = response.getWriter();  // 브라우저로의 출력 스트림(out)을 얻는다.
//        out.println("<html>");
//        out.println("<head>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println(year + "년 " + month + "월 " + day + "일은 ");
//        out.println(yoil + "요일입니다.");
//        out.println("</body>");
//        out.println("</html>");
//        out.close();
    }

    private boolean isValid(int year, int month, int day) {
        return true;
    }

    private static char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
}
