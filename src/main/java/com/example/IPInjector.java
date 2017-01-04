package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apereo.portal.soffit.renderer.SoffitRendererController;
import java.util.Map;
import org.springframework.ui.ModelMap;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class IPInjector {
    @Autowired
    SoffitRendererController soffitRendererController;

    @Value("${com.example.IPInjector.ip}")
    String ip;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/soffit/testEncrypt")
    public ModelAndView render(final HttpServletRequest req, final HttpServletResponse res) {
        ModelAndView mav = soffitRendererController.render(req, res, "testEncrypt");
        mav.addObject("ip", ip);
        // // logger.error(mav.getModel().get("portalRequest"));

        // // Map m = mav.getModel();
        // // Iterator it = m.entrySet().iterator();
        // // while (it.hasNext()) {
        // //     Map.Entry pair = (Map.Entry)it.next();
        // //     logger.error(pair.getKey() + " = " + pair.getValue());
        // // }
        logger.error(mav.getModel().toString());

        return mav;
    }

}