package sam.ocr.escalade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sam.ocr.escalade.service.SiteService;
import sam.ocr.escalade.service.TopoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FrontendContentRestController {

    private final SiteService siteService;

    private final TopoService topoService;

    @Autowired
    public FrontendContentRestController(SiteService siteService, TopoService topoService){
        this.siteService = siteService;
        this.topoService = topoService;
    }

    @RequestMapping("/pays")
    public List<String> getCountries() {
        String[] varCountries = {"Afghanistan", "Albanie", "Algérie", "Allemagne", "Andorre", "Angola", "Anguilla", "Antigua & Barbuda", "Argentine", "Arménie", "Aruba", "Australie", "Autriche", "Azerbaidjan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgique", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivie", "Bosnia & Herzegovina", "Botswana", "Bresil", "British Virgin Islands", "Brunei", "Bulgarie", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central Arfrican Republic", "Chad", "Chile", "Chine", "Colombie", "Congo", "Cook Islands", "Costa Rica", "Cote D Ivoire", "Croatia", "Cuba", "Curacao", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands", "Faroe Islands", "Fiji", "Finland", "France", "Polynésie Française", "Gabon", "Gambia", "Georgie", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica", "Japan", "Jersey", "Jordanie", "Kazakhstan", "Kenya", "Kiribati", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauro", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russia", "Rwanda", "Saint Pierre & Miquelon", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "St Kitts & Nevis", "St Lucia", "St Vincent", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor L'Este", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks & Caicos", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Virgin Islands (US)", "Yemen", "Zambia", "Zimbabwe"};
        ArrayList<String> countries = new ArrayList<String>(Arrays.asList(varCountries));
        return countries;
    }

    @RequestMapping("/nomSite")
    public List<String> getNomSite() {
        return siteService.getAllNoms();
    }

    @RequestMapping("/sujetTopo")
    public List<String> getTitreAndDescriptionTopo(){
        return topoService.getAllTitreAndDescription();
    }

}
