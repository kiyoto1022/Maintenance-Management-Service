package com.service.maintenance.presentation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.service.maintenance.presentation.view.ContractRegistForm;
import com.service.maintenance.presentation.view.maintenance.contract.ContractRequest;
import com.service.maintenance.presentation.view.maintenance.contract.ContractResponse;

//TODO: 別プロジェクトに移動予定　動作確認用に作成
@Controller
public class SampleController {
    
    @RequestMapping({"/", "/dashboard"})
    public String home(Model model) {
        return "dashboard/index";
    }
    
    @RequestMapping(value = "/contract/regist.html", method = RequestMethod.GET)
    public String registrationInput(Model model) {
    	model.addAttribute("contractRegistForm", new ContractRegistForm());
        return "contract/regist";
    }

    @RequestMapping(value = "/contract/complete.html", method = RequestMethod.POST)
    public String toRegister(@ModelAttribute("contractRegistForm") ContractRegistForm form, BindingResult result, Model model) {
   
    	final String uri = "http://localhost:8080/maintenance/contract";
    	 
    	ContractRequest request = new ContractRequest(form.getName(), form.getFiscalYear(), form.getAmount(), form.getRate());
     
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(uri, request, ContractResponse.class);
        
        return "contract/complete";
    }
    
    @RequestMapping("/contract/list.html")
    public String contractList(Model model) {
    	
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<List<ContractResponse>> response =
    	        restTemplate.exchange("http://localhost:8080/maintenance/contract/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<ContractResponse>>() {});

    	List<ContractResponse> contracts = response.getBody();
    	
    	model.addAttribute("contracts", contracts);
        return "contract/list";
    }
    
    @RequestMapping(value="/contract/search.html", method=RequestMethod.POST)
    public String contractSearch(Model model, @RequestParam("contractId") String id) {
    	
    	Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        
    	RestTemplate restTemplate = new RestTemplate();
    	ContractResponse result = restTemplate.getForObject("http://localhost:8080/maintenance/contract/{id}", ContractResponse.class, params);
    	
    	List<ContractResponse> contracts = new ArrayList<ContractResponse>();
    	contracts.add(result);
    	model.addAttribute("contracts", contracts);

    	return "contract/list";
    }

}