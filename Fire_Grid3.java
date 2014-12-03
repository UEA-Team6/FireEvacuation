/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample1;
//import fireevac.Input_diji2;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author Bilal
 */
public class Fire_grid3 extends java.applet.Applet {

    /**
     * Initializes the applet Fire_grid3
     */
    
    //public Input_diji2 t3=new Input_diji2();
    public static int size=6,grid_val=0,colid,colid2,rowid,rowid2,size2;
    public static int grid_num[][];
    public static int cost_mat[][];
    public static int curpos[];
    public int path[];
    public int pathcount;
    
    
    int obstacle[]=new int[1000];
    int human[]=new int[100];
    int maindoor = 9929;
    int obstcount,humancount;
  /*  public  void proc()
    {
        for(int i=0;i<size;i++)
            {
                for(int j=0;j<size;j++)
                {   
                    grid_num[i][j]=grid_val;
                    ++grid_val;
                }
            }
        
          
    }*/
    
    public void call()
    {
     
        top_left();
        top_right();
        bottom_left();
        bottom_right();
        top_row();
        bottom_row();
        left_col();
        right_col();
        middle();
      //  display();
        checkhumanandobstacle();
        dijik();
          
    }
     
    public void display()
    {
           for(int i=0;i<size2;i++)
            {
                for(int j=0;j<size2;j++)
                {   
                    System.out.print(cost_mat[i][j]+" ");
                }
                
                System.out.println();
            }
    }
          
      public void top_left()
    {
        colid=grid_num[0][1];
        cost_mat[0][colid]=1;
        
        colid=grid_num[1][0];
        cost_mat[0][colid]=1;
        
        colid=grid_num[1][1];
        cost_mat[0][colid]=1;
        
    }
    
    public void top_right()
    {   
        rowid=grid_num[0][size-1];
        
        colid=grid_num[0][size-2];
        cost_mat[rowid][colid]=1;
        
        colid=grid_num[1][size-2];
        cost_mat[rowid][colid]=1;
        
        colid=grid_num[1][size-1];
        cost_mat[rowid][colid]=1;
        
    }
    
    public void bottom_left()
    {
        rowid=grid_num[size-1][0];
        
        colid=grid_num[size-1][1];
        cost_mat[rowid][colid]=1;
        
        colid=grid_num[size-2][0];
        cost_mat[rowid][colid]=1;
        
        colid=grid_num[size-2][1];
        cost_mat[rowid][colid]=1;     
     
    }
    
    public void bottom_right()
    {
        rowid=grid_num[size-1][size-1];
        
        colid=grid_num[size-1][size-2];
        cost_mat[rowid][colid]=1;
        
        colid=grid_num[size-2][size-2];
        cost_mat[rowid][colid]=1;
        
        colid=grid_num[size-2][size-1];
        cost_mat[rowid][colid]=1;     
        
    }
    
    public void top_row()
    {
        
        for(colid=1;colid<size-1;colid++)
        {
            rowid=grid_num[0][colid];
            colid2=colid;
            
            colid=grid_num[0][colid2-1];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[0][colid2+1];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[1][colid2-1];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[1][colid2];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[1][colid2+1];
            cost_mat[rowid][colid]=1;
            
            colid=colid2;
        }
    }
    
    public void bottom_row()
    {
        for(colid=1;colid<size-1;colid++)
        {
            rowid=grid_num[size-1][colid];
            colid2=colid;
            
            colid=grid_num[size-1][colid2-1];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[size-1][colid2+1];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[size-2][colid2-1];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[size-2][colid2];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[size-2][colid2+1];
            cost_mat[rowid][colid]=1;
            
            colid=colid2;
        }
        
    }
    public void left_col()
    {
        for(rowid=1;rowid<size-1;rowid++)
        {
            rowid2=rowid;
            rowid=grid_num[rowid][0];
            
            colid=grid_num[rowid2-1][0];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[rowid2+1][0];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[rowid2-1][1];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[rowid2][1];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[rowid2+1][1];
            cost_mat[rowid][colid]=1;
            
           rowid=rowid2;
        }
    }
    
    public void right_col()
    {
        for(rowid=1;rowid<size-1;rowid++)
        {
            rowid2=rowid;
            rowid=grid_num[rowid][size-1];
            
            colid=grid_num[rowid2-1][size-1];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[rowid2+1][size-1];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[rowid2-1][size-2];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[rowid2][size-2];
            cost_mat[rowid][colid]=1;
            
            colid=grid_num[rowid2+1][size-2];
            cost_mat[rowid][colid]=1;
            
           rowid=rowid2;
        }
    }
    
  public void middle()
  {
      for(int i=1;i<size-1;i++)
      {
          for(int j=1;j<size-1;j++)
          {
             
              rowid=grid_num[i][j];
              
              colid=grid_num[i][j-1];
              cost_mat[rowid][colid]=1;
              
              colid=grid_num[i][j+1];
              cost_mat[rowid][colid]=1;
              
              colid=grid_num[i-1][j-1];
              cost_mat[rowid][colid]=1;
              
              colid=grid_num[i-1][j];
              cost_mat[rowid][colid]=1;
              
              colid=grid_num[i-1][j+1];
              cost_mat[rowid][colid]=1;
              
              colid=grid_num[i+1][j-1];
              cost_mat[rowid][colid]=1;
              
              colid=grid_num[i+1][j];
              cost_mat[rowid][colid]=1;
              
              colid=grid_num[i+1][j+1];
              cost_mat[rowid][colid]=1;
              
          }
      }
  }
  
  public void dijik()
    {
        int m=0;
        int[] preD = new int[size2];
		int min = 999, nextNode = 0; 
		int[] distance = new int[size2]; 
                int[][] matrix = new int[size2][size2]; 
		int[] visited = new int[size2]; 
		
		System.out.println("Enter the cost matrix"); 
		
		for(int i = 0; i < distance.length; i++){
			
			visited[i] = 0; //initialize visited array to zeros
			
			preD[i] = 0;
			
			for(int j = 0; j < distance.length; j++){
				
				matrix[i][j] = cost_mat[i][j]; //fill the matrix
				
				if(matrix[i][j]==0){
					
					matrix[i][j] = 999; // make the zeros as 999
					
				}
				
			}
			
		}
		
		distance = matrix[0]; //initialize the distance array
		visited[0] = 1; //set the source node as visited
		distance[0] = 0; //set the distance from source to source to zero which is the starting point
		
		for(int counter = 0; counter < size2; counter++){
			
			min = 999;
			
			for(int i = 0; i < size2; i++){
				
				if(min > distance[i] && visited[i]!=1){
					
					min = distance[i];
					nextNode = i;
					
				}
				
			}
			
			visited[nextNode] = 1;
			
			for(int i = 0; i < size2; i++){
				
				if(visited[i]!=1){
					
					if(min+matrix[nextNode][i] < distance[i]){
						
						distance[i] = min+matrix[nextNode][i];
						preD[i] = nextNode;
						
					}
					
				}
				
			}
			
		}
		
		for(int i = 0; i < size2; i++){
			
			System.out.print("|" + distance[i]);
			
		}
		System.out.println("|");
                
                
		RunnableDemo r1[] = new RunnableDemo[humancount]; 
                curpos=new int[humancount];
		int j;
                
		for(int i = 0; i < humancount; i++){
                        int path_human=human[i];
                        //System.out.print("human path"+path_human);

                        curpos[i]=human[i];
                        path=new int[1000];
                        
                        pathcount=0;
			if(path_human!=0){
                
				
                            System.out.print("Path = " + path_human);
                              //  path[pathcount++]=i;                                
                                 path[pathcount++]=path_human;
				j = path_human;
				do{
					
					j=preD[j];
                                        path[pathcount++]=j;
					System.out.print(" <- " + j);
					
				}while(j!=0);
                                
                                r1[i]=new RunnableDemo("Thread"+i,pathcount,path,i);
                                r1[i].start();        
                  
                          /*  for(int k=0;k<pathcount;k++)
                            {
                                int quotient,remainder;
                                quotient=path[k]/size;
                                remainder=path[k]%size;
                                System.out.println(path[k]+":"+quotient+" "+remainder);
                            // System.out.print("hi");
                                butto[quotient][remainder].setBackground(Color.red);
                            } */
			System.out.println("Fire_ pathcount"+pathcount);
			
				
			}
			
                        System.out.println();
                        
		}
    }
 
public void checkhumanandobstacle()
{
  obstcount=0;
  humancount=0;
  
  for(int i=0;i<size;i++)
  {
      for(int j=0;j<size;j++)
      {
          //System.out.print(butto[i][j].getText());
                if ("Human".equals(butto[i][j].getText()))
                {
                    human[humancount++]=grid_num[i][j];
                }       
                else if("Door".equals(butto[i][j].getText()))
                {
                    maindoor=grid_num[i][j];
                }
                else if("Obstacle".equals(butto[i][j].getText()))    
                {
                    obstacle[obstcount++]=grid_num[i][j];
                }
                     
                
      }
}
  
  for(int i=0;i<obstcount;i++)
  { 
      int temp =obstacle[i];
      for(int j=0;j<size2;j++)
      { 
          cost_mat[j][temp]=0;
      }
  }
  
  System.out.println("Main_door number:"+maindoor);  
  System.out.print(humancount);
  System.out.println(obstcount);
}

    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.setSize(940,550);
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 300));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 300));

        jButton2.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Chair_small.jpg")); // NOI18N
        jButton2.setText("Chair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Door_small.jpg")); // NOI18N
        jButton3.setText("Door");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Human_small.jpg")); // NOI18N
        jButton4.setText("Human");
        jButton4.setToolTipText("Human");
        jButton4.setName("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Flower vase_small.jpg")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Cupboard_small.jpg")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Table_small.jpg")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Dijikstra-algo");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Clear path");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton8)
                        .addGap(68, 68, 68)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setMaximumSize(new java.awt.Dimension(550, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(550, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 550));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("OK");
        jButton1.setPreferredSize(new java.awt.Dimension(200, 137));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Please enter the resolution of the grid");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Firevac- Evacuation Simulator");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
public int iconval;

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        //size=Integer.parseInt(jTextField1.getText());
        
        //int grid_num[][]=new int[size][size],grid_val=0;
        size=Integer.parseInt(jTextField1.getText());
        size2=size*size;
        grid_num=new int[size][size];
        cost_mat=new int[size2][size2];
    
        
        jPanel1.remove(jButton1);
        jPanel1.remove(jTextField1);
        jPanel1.remove(jLabel1);
        jPanel1.remove(jLabel2);
        jPanel1.setLayout(new java.awt.GridLayout(size,size));
        jPanel1.revalidate();
        jPanel1.repaint();
         
         
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {   
                butto[i][j]=new javax.swing.JButton();
                butto[i][j].addActionListener(al);
                jPanel1.add(butto[i][j]);
            }
        }
        
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {   
                grid_num[i][j]=grid_val;
                ++grid_val;
            }
        }
        
        

        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
iconval=1;        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
iconval=2;        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
iconval=3;        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
iconval=4;        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
iconval=5;        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
iconval=6;        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        call();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                butto[i][j].setBackground(null);
            }
        }

    }//GEN-LAST:event_jButton9ActionPerformed
    java.awt.event.ActionListener al= new java.awt.event.ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
         
         JButton myButton = (JButton)e.getSource();
         
         if(myButton.getIcon()!=null)
         {
         myButton.setIcon(null);
         myButton.setText(null);
         }
         else if(iconval==1)
         {
         myButton.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Colours\\Lightblue.jpg"));
         myButton.setText("Obstacle");
         }
         else if(iconval==2)
         {
         myButton.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Colours\\Orange.jpg"));
         myButton.setText("Obstacle");
         }
          else if(iconval==3)
         {
         myButton.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Colours\\Blue.jpg"));
         myButton.setText("Door");
         }
          else if(iconval==4)
         {
         myButton.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Colours\\Yellow.jpg"));
         myButton.setText("Obstacle");
         }
          else if(iconval==5)
         {
         myButton.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Colours\\Black.jpg"));
         myButton.setText("Human");
         }
          else if(iconval==6)
         {
         myButton.setIcon(new javax.swing.ImageIcon("F:\\Workspace\\FireEvacuation\\Image files\\Colours\\Brown.jpg"));
         myButton.setText("Obstacle");
         }
          else if(iconval==7)
         {
         myButton.setIcon(null);
         myButton.setToolTipText(null);
         }
             
         jPanel1.revalidate();
         jPanel1.repaint();
         String[] arg=new String[0];
//         t3.call();
                    
            // System.exit(0);
        }
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    public static javax.swing.JButton[][] butto= new javax.swing.JButton[100][100];
       
   
   
}

