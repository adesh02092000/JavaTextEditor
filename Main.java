package textEditor;


import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;


public class Main {

	
		public static void main(String [] args)
		{	
			JFrame f=new JFrame();
			JTextPane ta=new JTextPane();
			JScrollPane pane=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			f.setTitle("Text Editor");
			f.setSize(900,600);
			JMenuBar m=new JMenuBar();
			JMenu file=new JMenu("File");
			JMenu edit=new JMenu("Edit");
			JMenu help=new JMenu("Help");
			JMenuItem cut=new JMenuItem("Cut");
			JMenuItem copy=new JMenuItem("Copy");
			JMenuItem paste=new JMenuItem("Paste");
			JMenuItem select=new JMenuItem("Select all");
			JMenuItem undo=new JMenuItem("Undo");
			JMenuItem newfile=new JMenuItem("Open File");
			JMenuItem savefile=new JMenuItem("Save File");
			JMenuItem exit=new JMenuItem("Exit");
			JMenuItem redo=new JMenuItem("Redo");
			edit.add(cut);
			edit.add(copy);
			edit.add(select);
			edit.add(paste);
			edit.add(undo);
			edit.add(redo);
			file.add(newfile);
			file.add(savefile);
			file.add(exit);
			m.add(file);
			m.add(edit);
			m.add(help);
			String []s={"SansSerif","Serif"};
			//String s[] =GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
			String []backg={"White","Red","Black","Pink","Yellow","Green"};
			String []fontc={"Black","Red","White","Pink","Yellow","Green"};
			String[] fontsize={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90"};		
			JComboBox font=new JComboBox(fontsize);
			JComboBox color=new JComboBox(backg);
			JComboBox j=new JComboBox(s);
			JComboBox fontcolor=new JComboBox(fontc);
			JToolBar toolbar=new JToolBar();
			toolbar.setBounds(5,40,100,30);
			JLabel label=new JLabel("Font");
			toolbar.add(label);
			toolbar.addSeparator();
			toolbar.add(j);
			//b1.setSize(20,20);
			toolbar.addSeparator();
			JLabel label1=new JLabel("Background Color");
			toolbar.add(label1);
			toolbar.addSeparator();
			toolbar.add(color);
			toolbar.addSeparator();
			JLabel label2=new JLabel("Font Size");
			toolbar.add(label2);
			toolbar.addSeparator();
			toolbar.add(font);
			toolbar.addSeparator();
			JLabel label3=new JLabel("Font Color");
			toolbar.add(label3);
			toolbar.addSeparator();
			toolbar.add(fontcolor);
			for(int i=0;i<90;++i)
			{
				toolbar.addSeparator();
			}
			m.setBounds(5,5,400,40);
			ta.setBounds(5,80,400,400);
			f.setLocationRelativeTo(null);
			f.add(m);
			f.add(toolbar,BorderLayout.NORTH);
			f.setJMenuBar(m);
			//f.add(ta);
			f.add(pane);
			f.setVisible(true);
		
			JFileChooser choose=new JFileChooser();
			UndoManager manager = new UndoManager();
			//UndoManager manager1=new UndoManager();
			ta.getDocument().addUndoableEditListener(manager);
			cut.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ta.cut();
				}
			});
			copy.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ta.copy();
				}
			});
			paste.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ta.paste();
					//Font f=new Font("Arial",1,20);
					//ta.setFont(f);
				}
			});
			select.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ta.selectAll();
				}
			});
			j.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Action serif= new StyledEditorKit.FontFamilyAction("Serif",java.awt.Font.SERIF);
					Action sans= new StyledEditorKit.FontFamilyAction("Sans",java.awt.Font.SANS_SERIF);
					if(j.getSelectedItem().toString().equals("Serif"))
					{	
						serif.actionPerformed(e);
						
					}
				}
			});
				j.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Action serif = new StyledEditorKit.FontFamilyAction("Serif", java.awt.Font.SERIF);
				    Action sans = new StyledEditorKit.FontFamilyAction("Sans", java.awt.Font.SANS_SERIF);
					if(j.getSelectedItem().toString().equals("SansSerif"))
					{	
						sans.actionPerformed(e);
					}
				}
			});
				color.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(color.getSelectedItem().equals("Red"))
						{
							ta.setBackground(java.awt.Color.RED);
						}
						if(color.getSelectedItem().equals("White"))
						{
							ta.setBackground(java.awt.Color.WHITE);
						}
						if(color.getSelectedItem().equals("Black"))
						{
							ta.setBackground(java.awt.Color.BLACK);
						}
						if(color.getSelectedItem().equals("Yellow"))
						{
							ta.setBackground(java.awt.Color.YELLOW);
						}
						if(color.getSelectedItem().equals("Green"))
						{
							ta.setBackground(java.awt.Color.GREEN);
						}
						if(color.getSelectedItem().equals("Pink"))
						{
							ta.setBackground(java.awt.Color.PINK);
						}
						
					}
				});
				fontcolor.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
//						//ta.setForeground=JColorChooser.showDialog(f,"choose color",Color.re)
						if(fontcolor.getSelectedItem().equals("Red"))
						{
							ta.setForeground(java.awt.Color.RED);
						}
						if(fontcolor.getSelectedItem().equals("White"))
						{
							ta.setForeground(java.awt.Color.WHITE);
						}
						if(fontcolor.getSelectedItem().equals("Black"))
						{
							ta.setForeground(java.awt.Color.BLACK);
						}
						if(fontcolor.getSelectedItem().equals("Yellow"))
						{
							ta.setForeground(java.awt.Color.YELLOW);
						}
						if(fontcolor.getSelectedItem().equals("Green"))
						{
							ta.setForeground(java.awt.Color.GREEN);
						}
						if(fontcolor.getSelectedItem().equals("Pink"))
						{
							ta.setForeground(java.awt.Color.PINK);
						}
					} 
				});
				font.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String selectedfontsize=(String) font.getSelectedItem();
					int temp=Integer.parseInt(selectedfontsize);
						System.out.println(temp);
						
						Font newfont = new Font("serif",Font.PLAIN,temp);
						
						//Font newfont=ta.getFont().deriveFont(temp);
						ta.setFont(newfont);
					}
				});	
				
					
			undo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try
						{	
						manager.undo();
						}
						catch(CannotUndoException e)
						{
							e.printStackTrace();
						}
					}
				});
			redo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					manager.redo();
				}
			});
			newfile.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int returnVal = choose.showOpenDialog(f);// to open the dilaog box for opening a file

			        if (returnVal == JFileChooser.APPROVE_OPTION)// if users selects a file
			        {
			           
			            try {
			            	 File file = choose.getSelectedFile();
			            	 FileReader r=new FileReader(file);
			            	 ta.read(r,"");
			            			 
			            	 
							 
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			            
			           // System.out.println("Selected file: " + file.getAbsolutePath());
			        }
				}
			});
			savefile.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int returnval=choose.showSaveDialog(f);
					if(returnval==JFileChooser.APPROVE_OPTION)
					{
						File file=choose.getSelectedFile();
						try {
							FileWriter w=new FileWriter(file);
							ta.write(w);
							w.flush();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				}
			});
			exit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(f,"THANK YOU");
					System.exit(0);
				}
			});
			
		}
	

}
