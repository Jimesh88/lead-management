package com.jimmy.finalproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.BarChart;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.Plot;
import com.googlecode.charts4j.Plots;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Opportunity;
import com.jimmy.finalproject.service.OpportunityChartService;

@Controller
@RequestMapping("/chart")
public class ChartController {

	@Autowired
	OpportunityChartService opportunityChartService;
	
	
	
	
	@RequestMapping(value="opp/{month}",method=RequestMethod.GET)
	public @ResponseBody String plotChart(@PathVariable("month")String month,Model model,HttpServletRequest request)
	{
		int procount=0;
		int quacount=0;
		int anacount=0;
		int valuecount=0;
		int decicount=0;
		int percepcount=0;
		int proposalcount=0;
		int negocount=0;
		int closedcount=0;
		int woncount=0;
		int totalCount=0;
		
		DbUser user= (DbUser)request.getSession(false).getAttribute("user");
		
		List<Opportunity> ols = opportunityChartService.getOpportunitiesByMonth(month,user);
		for(Opportunity o : ols)
		{
			if(o.getStage().equals("Prospecting"))
			{
				procount++;
			}
			else if(o.getStage().equals("Qualification"))
			{
				quacount++;
			}
			else if(o.getStage().equals("Needs Analysis"))
			{
				
				anacount++;
			}
			else if(o.getStage().equals("Value Proposition"))
			{
				valuecount++;
			}
			else if(o.getStage().equals("Id. Decision Makers"))
			{
				decicount++;
			}
			else if(o.getStage().equals("Perception Analysis"))
			{
				percepcount++;
			}
			else if(o.getStage().equals("Proposal/Price Quote"))
			{
				proposalcount++;
			}
			else if(o.getStage().equals("Negotiation/Review"))
			{
				negocount++;
			}
			else if(o.getStage().equals("Closed Won"))
			{
				woncount++;
			}
			else
				closedcount++;
			 totalCount = procount+anacount+closedcount+decicount+negocount+ percepcount+proposalcount+quacount+woncount+valuecount;
		}
		
		Plot plot = Plots.newPlot(Data.newData( procount, quacount, anacount, valuecount, decicount,percepcount,proposalcount,negocount, woncount,closedcount));
		 //Plot plot = Plots.newPlot(Data.newData(45, 32, 56, 65, 76,34,65,76, 45,76));

		 final BarChart chart=GCharts.newBarChart(plot);
		 AxisLabels stages = AxisLabelsFactory.newAxisLabels("Stages", 50.0);
		 AxisLabels score = AxisLabelsFactory.newAxisLabels("Score", 50.0);

		chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("Prospecting", "Qualifi.", "Analysis", "Proposition","DecisMakers","Percep. Analysis","Proposal","Negotiation","Won","Lost"));
        chart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, 100));
        chart.setSize(750, 350);
        chart.setBarWidth(55);
        chart.setSpaceWithinGroupsOfBars(35);
        chart.addXAxisLabels(stages);
        chart.addYAxisLabels(score);
		return chart.toURLString();
	}
	
	
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getPage()
	{
		return "chart/myChart";
	}
	
}
