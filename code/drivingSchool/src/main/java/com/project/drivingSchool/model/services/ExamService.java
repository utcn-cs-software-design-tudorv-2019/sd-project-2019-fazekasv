package com.project.drivingSchool.model.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ExamService {

	Map<String,Map<String,Boolean>> examItems = new HashMap<>();
	
	static int value = 0;
	String qq = null;
	
	public void initializeQuestions() {
		
		Map<String,Boolean> answers = new HashMap<>();
		
		answers.put("niciuna;", false);
		answers.put("deosebirea constă în durata de imobilizare a motocicletei;", true);
		answers.put("deosebirea constă în modul de aşezare şi asigurare a motocicletei pe drum;;", false);
		examItems.put("Care este deosebirea dintre oprire şi staţionare?", answers);
		
		answers = new HashMap<>();
		answers.put("nu;", true);
		answers.put("da;", false);
		answers.put("acest aspect nu este reglementat legal;", false);
		examItems.put("Vă este permis să conduceţi motocicleta pe drumurile publice fără să asiguraţi contactul cu partea carosabilă pe ambele roţi?"
				, answers);
		
		answers = new HashMap<>();
		answers.put(" continuă deplasarea, dacă barierele nu sunt coborâte;;", false);
		answers.put("opreşte, deoarece barierele sunt orizontale sau urmează să coboare;;", true);
		answers.put(" continuă deplasarea fără interdicţie, deoarece luminile semnalizează doar prezenţa unei treceri la nivel cu calea ferată;", false);
		examItems.put("Cum procedează conducătorul de motocicletă atunci când, apropiindu-se de o trecere la nivel cu calea ferată, prevăzută cu bariere (semibariere), cele două lumini roşii funcţionează intermitent-alternativ?"
				, answers);
		
		answers = new HashMap<>();
		answers.put("se suspendă piciorul într-o chingă rigidă;", false);
		answers.put("u atele sau cu un bandaj gros, de la degete până la genunchi;;", true);
		answers.put("u atele sau cu un bandaj gros, de la degete până la genunchi;", true);
		examItems.put("Cum se imobilizează fractura labei piciorului?"
				, answers);
		
		answers = new HashMap<>();
		answers.put("da;;", true);
		answers.put("numai dacă sunteţi implicat într-un accident de circulaţie;", false);
		answers.put("nu;", false);
		examItems.put("Conduceţi motocicleta pe drumurile publice şi refuzaţi recoltarea unor probe biologice în vederea stabilirii alcoolemiei. Veţi fi pedepsit penal?"
				, answers);
		
	}
	
	public String getQuestion() {
		if (value == 0) {
		initializeQuestions();
		value = 1;
		}
		
		int size = examItems.keySet().size();
		int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
		int i = 0;
		for(String obj : examItems.keySet())
		{
		    if (i == item)
		        qq =  obj;
		    i++;
		}
		 return qq;
	}
	
}
