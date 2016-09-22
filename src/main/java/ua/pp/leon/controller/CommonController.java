package ua.pp.leon.controller;

import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.pp.leon.domain.User;
import ua.pp.leon.service.HolidayService;

/**
 *
 * @author Andrii Zalevskyi <azalevskyi@gmail.com>
 */
@Controller
public class CommonController {

    private static final Logger LOG = Logger.getLogger(CommonController.class.getName());

    @Autowired
    private HolidayService holidayService;

    @RequestMapping(value = {"/", "/home", "login"})
    public String home(Model model) {
        LOG.info("/home");
        model.addAttribute("user", new User());
        return "home";
    }

    @RequestMapping(value = "/home", params = {"error"})
    public String loginError(Model model) {
        LOG.log(Level.INFO, "/home?error");
        model.addAttribute("loginError", true);
        return "home";
    }

    @RequestMapping(value = "/home", params = {"logout"})
    public String logout(Model model) {
        LOG.log(Level.INFO, "/home?logout");
        return "home";
    }

    @RequestMapping(value = "/secure", method = RequestMethod.GET)
    public String secure(Model model, HttpSession session) {
        Date from = (Date) session.getAttribute("from");
        Date to = (Date) session.getAttribute("to");
        if (from == null) {
            from = new Date();
            session.setAttribute("from", from);
        }
        if (to == null) {
            to = new Date();
            session.setAttribute("to", to);
        }
        LOG.log(Level.INFO, "/secure: [{0} : {1}]", new Object[]{from, to});
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("holidays", session.getAttribute("holidays"));
        return "secure";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findHolidays(Model model, HttpSession session, Locale locale
            , @RequestParam Date from, @RequestParam Date to) {
        LOG.info("/find");
        session.setAttribute("from", from);
        session.setAttribute("to", to);
        session.setAttribute("holidays", holidayService.findByHolidayDateBetween(from, to, locale));
        return "redirect:/secure";
    }

    @RequestMapping(value = "/403")
    public String code403() {
        LOG.info("/403");
        return "403";
    }
}
