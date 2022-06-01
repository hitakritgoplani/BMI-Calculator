import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
class MainFrame extends Frame implements ActionListener  
{
	double final_bmi,final_bmr;
	int final_meta,flag=0;
	int age;
	String str1,str2a,str2b,str3;
	double height,weight;
	
	TextField t1a = new TextField(""); //output
	TextField t1b = new TextField("");
	TextField t2 = new TextField(""); //age
	TextField t3a = new TextField(""); //height
	TextField t3b = new TextField("");
	TextField t4 = new TextField(""); //weight
	
	JRadioButton checkBox1 = new JRadioButton("Male");
	JRadioButton checkBox2 = new JRadioButton("Female");
	
	ButtonGroup group = new ButtonGroup();
	ButtonGroup group_height = new ButtonGroup();
	
	JButton checkBox3 = new JButton("ft+in");
	JButton checkBox4 = new JButton("cms");
	JButton bmi = new JButton("BMI");
	JButton bmr = new JButton("BMR");
	JButton meta_age = new JButton("Metabolic Age");
	JButton clear = new JButton("CLEAR");
	   
	String data[][]={ {"Category","Range"},
	                  {"Underweight","<=18.5"},    
                      {"Normal Weight","18.5-24.9"},    
                      {"Over Weight","25-29.9"},
				      {"Obesity",">=30"}};    
    String column[]={"Category","Range"};     
	JTable bmi_table = new JTable(data,column);
	
	String data1[][]={{"Age","Male","Female"},
	                 {"20-29","39.5","37.0"},
			        {"30-39","39.5","36.5"},
				    {"40-49","38.5","36.5"},
					{"50-59","37.5","35.0"},
					{"60-69","36.5","34.0"},
	                {"70-79","35.5","33.0"}};    
    String column1[]={"Age","Male","Female"};   
	
	JTable bmr_table = new JTable(data1,column1);
	
	String people[][] = {{"VESIT SE Comps"},
						{"Developed by Group 3"},
						{"11 - Shruti Dalvi"},
						{"18 - Hitakrit Goplani"},
						{"42 - Swara Nabar"}};
						
	String column2[]={""};
	
	JTable table1 = new JTable(people,column2);
	
	MainFrame()
	{
		this.setLayout(null);
		
		Font font_label = new Font("Monospaced", Font.BOLD, 17);
		Font font_textfield = new Font("Monospaced", Font.PLAIN, 15);
		Font font_button = new Font("Monospaced", Font.BOLD, 25);
		Font font_output = new Font("Monospaced", Font.BOLD, 30);
		
		Color bg = new Color(249,228,183);
		Color bg1 = new Color(169,149,123);
		Color buttons = new Color(131,105,83);
		
		table1.setBounds(810,400,500,250);
		table1.setVisible(true);
		table1.setBackground(bg1);
		table1.setForeground(Color.black);
		table1.setFont(font_button);
		table1.setRowHeight(50);
		this.add(table1);
		
		this.add(bmi_table);
		
		//ouput screen
		
		t1a.setVisible(true);
		t1a.setEditable(false);
		t1a.setBackground(bg1);
		t1a.setForeground(Color.white);
		t1a.setBounds(75,85,700,75);
		t1a.setFont(font_output);
		this.add(t1a);
		
		t1b.setVisible(true);
		t1b.setEditable(false);
		t1b.setBackground(bg1);
		t1b.setForeground(Color.white);
		t1b.setBounds(75,160,700,75);
		t1b.setFont(font_output);
		this.add(t1b);
		
		//gender
		
		Label lgender = new Label("Gender:");
		lgender.setBounds(75,250, 65, 26);  
		lgender.setBackground(bg);
		lgender.setForeground(Color.black);		
		lgender.setFont(font_label);
		this.add(lgender);
		  
        checkBox1.setBounds(200,250,100,30); 
        checkBox1.setBackground(bg);
		checkBox1.setForeground(Color.black);		
		checkBox1.setFont(font_label);		
        this.add(checkBox1);
	    
        checkBox2.setBounds(400,250, 100,30); 
        checkBox2.setBackground(bg);
		checkBox2.setForeground(Color.black);		
		checkBox2.setFont(font_label);		
		this.add(checkBox2);
		
		group.add(checkBox1);
		group.add(checkBox2);
		
		//age
		
		Label lage = new Label("Age:");
		lage.setBounds(75,300, 30, 26);  
		lage.setBackground(bg);
		lage.setForeground(Color.black);		
		lage.setFont(font_label);
		this.add(lage);
		
		t2.setVisible(true);
		t2.setForeground(Color.black);
		t2.setBounds(120,300,65,30);
		t2.setFont(font_textfield);
		this.add(t2);
		
		
		//height
		
		Label lheight = new Label("Height:");
		lheight.setBounds(75, 350,75, 26);  
		lheight.setBackground(bg);
		lheight.setForeground(Color.black);		
		lheight.setFont(font_label);
		this.add(lheight);
		
		t3a.setVisible(true);
		t3a.setForeground(Color.black);
		t3a.setBounds(150,350,150,30);
		t3a.setFont(font_textfield);
		this.add(t3a);
		
		t3b.setVisible(false);
		t3b.setForeground(Color.black);
		t3b.setBounds(235,350,75,30);
		t3b.setFont(font_textfield);
		this.add(t3b);
		
		checkBox3.setBounds(320,350,90,30); 
        checkBox3.setBackground(bg);
		checkBox3.setForeground(Color.black);		
		checkBox3.setFont(font_label);		
        this.add(checkBox3);
	    
        checkBox4.setBounds(430,350,75,30); 
        checkBox4.setBackground(bg);
		checkBox4.setForeground(Color.black);		
		checkBox4.setFont(font_label);		
		this.add(checkBox4);
		
		group_height.add(checkBox3);
		group_height.add(checkBox4);
		
		//weight
		
		Label lweight = new Label("Weight in kgs:");
		lweight.setBounds(200,300,150, 26);
		lweight.setBackground(bg);
		lweight.setForeground(Color.black);
		lweight.setFont(font_label);
		this.add(lweight);
		
		t4.setVisible(true);
		t4.setForeground(Color.black);
		t4.setBounds(360,300,100,30);
		t4.setFont(font_textfield);
		this.add(t4);		
		
		//calculate bmi button
		
		bmi.setBounds(75,400,100,60);
		bmi.setBackground(buttons);
		bmi.setForeground(Color.white);
		bmi.setFont(font_button);
		this.add(bmi);
		
		
		
		//calculate bmr button
		
		bmr.setBounds(185,400,100,60);
		bmr.setBackground(buttons);
		bmr.setForeground(Color.white);
		bmr.setFont(font_button);
		this.add(bmr);
		
		//calculate meta age 
		
		meta_age.setBounds(295,400,350,60);
		meta_age.setBackground(buttons);
		meta_age.setForeground(Color.white);
		meta_age.setFont(font_button);
		this.add(meta_age);
		
		//bmi chart button
		
		JButton bmichart = new JButton(new AbstractAction("BMI Chart"){
			public void actionPerformed(ActionEvent ae)
			{
				bmr_table.setVisible(false);
				bmi_table.setVisible(true);
			}
		});	
		
		bmichart.setBounds(75,500,210,60);
		bmichart.setBackground(buttons);
		bmichart.setForeground(Color.white);
		bmichart.setFont(font_button);
		this.add(bmichart);
		
		//bmr chart buuton
		
		JButton bmrchart = new JButton(new AbstractAction("BMR Chart"){
			public void actionPerformed(ActionEvent ae)
			{
				bmi_table.setVisible(false);
				bmr_table.setVisible(true);
			}
		});
		
		bmrchart.setBounds(295,500,175,60);
		bmrchart.setBackground(buttons);
		bmrchart.setForeground(Color.white);
		bmrchart.setFont(font_button);
		this.add(bmrchart);
		
		//clear 
		
		clear.setBounds(480,500,165,60);
		clear.setBackground(buttons);
		clear.setForeground(Color.white);
		clear.setFont(font_button);
		this.add(clear);
		
		//bmi chart table
		
		bmi_table.setBounds(810,85,500,165);
		bmi_table.setVisible(false);
		bmi_table.setBackground(buttons);
		bmi_table.setForeground(Color.white);
		bmi_table.setFont(font_button);
		bmi_table.setRowHeight(30);
		
		this.add(bmi_table);
		
		//bmr chart table
		
		bmr_table.setBounds(810,85,500,220);
		bmr_table.setVisible(false);
		bmr_table.setBackground(buttons);
		bmr_table.setForeground(Color.white);
		bmr_table.setFont(font_button);
		bmr_table.setRowHeight(30);
		this.add(bmr_table);
		
		bmi.addActionListener(this);
		bmr.addActionListener(this);
		clear.addActionListener(this);
		meta_age.addActionListener(this);
		checkBox3.addActionListener(this);
		checkBox4.addActionListener(this);
	}
	public void calculateBmi(double height, double weight)
	{
		height = height/100;
		final_bmi = weight/(height*height);
	}
	public void calculateBmrAndmetaage(double height, double weight , int age)
	{
		
		if(checkBox1.isSelected()) //male
		{
			final_bmr = 66.5 + (13.75*weight) + (5.003*height) - (6.775*age);
			final_meta = (int)(( 88.362 + ( 13.397 * weight ) + ( 4.799 * height ) - final_bmr ) / 5.677);
		}
		if(checkBox2.isSelected()) //female
		{
			final_bmr =  655 + (9.563*weight) + (1.850*height) - (4.676*age);
			final_meta = (int)(( 447.593 + ( 9.247 * weight ) + ( 3.098 * height ) - final_bmr ) / 4.33);
		}
	}
	public static void main(String args[])
	{		
		MainFrame f = new MainFrame();	
		f.setTitle("BMI and BMR Calculator");
		f.setSize(1500,1500);
		f.setVisible(true);
		Color bg = new Color(249,228,183); 
		f.setBackground(bg);
		f.addWindowListener(new Close1());		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==clear)
		{
			flag=1;
			t1a.setText("");
			t1b.setText("");
			t2.setText("");
			t3a.setText("");
			t3b.setText("");
			t4.setText("");
			t1a.setVisible(true);
			t1b.setVisible(true);
			bmi_table.setVisible(false);
			bmr_table.setVisible(false);
			group.clearSelection();
			group_height.clearSelection();
		}
		
		if(ae.getSource()==clear&&flag!=1)
		{
			
			t1a.setText("");
			t1b.setText("");
			t2.setText("");
			t3a.setText("");
			t3b.setText("");
			t4.setText("");
			t1a.setVisible(true);
			t1b.setVisible(true);
			bmi_table.setVisible(false);
			bmr_table.setVisible(false);
			group.clearSelection();
			group_height.clearSelection();
		}
		
		if(ae.getSource()==checkBox3)
		{
			t3a.setBounds(150,350,75,30);;
			t3b.setVisible(true);
			flag=1;
		}
		
		if(ae.getSource()==checkBox4)
		{
			t3b.setVisible(false);
			t3a.setBounds(150,350,150,30);
			flag=0;
		}
		
		if(ae.getSource()==checkBox3&&flag!=1)
		{
			t3a.setBounds(235,450,75,30);
			t3b.setVisible(true);
		}
		
		str1 = t2.getText();
		str2a = t3a.getText();
		str3 = t4.getText();
		
		age = Integer.parseInt(str1);	
		height = Double.parseDouble(str2a);
		weight = Double.parseDouble(str3);
		
		if(flag == 1)
		{
			str2b = t3b.getText();
			double temp = Double.parseDouble(str2b);
			height = height*30.48 + temp*2.54;
		}
		
		if(ae.getSource()==bmi) 
		{
		    bmi_table.setVisible(false);
			bmr_table.setVisible(false);
			t1a.setVisible(true);
			t1b.setVisible(true);
			String result;
			calculateBmi(height,weight);
			String bmi_display = String.valueOf(final_bmi);	
			String unit = " kg/m^2";
			t1a.setText(bmi_display+unit);
			
			if(final_bmi<18.5)
				t1b.setText("Underweight");

			else if(18.5<final_bmi && final_bmi<24.9)
				t1b.setText("Normal healthy Weight");
			
			else if(25.0<final_bmi && final_bmi<29.9)
                t1b.setText("Overweight");

			else if(30.0<final_bmi && final_bmi<39.9)
				t1b.setText("Obese");

			else
				t1b.setText("Morbidly Obese");
		
		}
		
		if(ae.getSource()==bmr) 
		{   
	        bmi_table.setVisible(false);
			bmr_table.setVisible(false);
			t1a.setVisible(true);
			t1b.setVisible(true);
			calculateBmrAndmetaage(height,weight,age);
			String bmr_display = String.valueOf(final_bmr);
			t1b.setText("According to Harris Benedict Formula");
			String unit = " calories per day";
			t1a.setText(bmr_display+unit);
		}	
		
		if(ae.getSource()==meta_age) 
		{   
	        bmi_table.setVisible(false);
			bmr_table.setVisible(false);
			t1a.setVisible(true);
			t1b.setVisible(true);
			calculateBmrAndmetaage(height,weight,age);
			String meta_age_display = String.valueOf(final_meta);	
			t1a.setText(meta_age_display);
			t1b.setText("");
		}	
		
		
	}
}
class Close1 extends WindowAdapter
{
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
}