/*
 * This file is part of brainstorm2014portlet2a.
 *
 * brainstorm2014portlet2a is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * brainstorm2014portlet2a is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * brainstorm2014portlet2a. If not, see <http://www.gnu.org/licenses/>.
 */
package be.hubrussel.brainstorm2015portlet2a;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import be.hubrussel.brainstorm.domain.Persoon;
import be.hubrussel.brainstorm.service.BrainstormSessieService;

/**
 * Handles requests for the view mode.
 */
@Controller
@RequestMapping("VIEW")   // Een portlet heeft ook "EDIT" en "HELP" mode
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    @Autowired
    protected BrainstormSessieService brainstormSessieService=null; // ready for dependency injection

    @RenderMapping
    public String index(ModelMap model){
        List<Persoon> deLijst = brainstormSessieService.geefAllePersonen();
        model.addAttribute("personen", deLijst);
        return "/index";
    }
    // je zal naar index.jsp gaan
	
}
