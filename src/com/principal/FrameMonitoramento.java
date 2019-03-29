/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;


import com.bean.Atz;
import com.bean.Micro;
import com.bean.Monitoramento;
import com.bean.Pln0096r;
import com.dao.AtzJpaDAO;
import com.dao.MicroJpaDAO;
import com.dao.MonitoramentoJpaDAO;
import com.dao.Pln0096rJpaDAO;
import com.user.User;
import com.utils.DataHora;
import java.awt.Color;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiago.napoleao
 */
public class FrameMonitoramento extends javax.swing.JFrame {
 DataHora dataHora;
     
    /**
     * Creates new form FrameP
     */
        
       
        
    public FrameMonitoramento() {
        initComponents();
        codigoTxt.setText(User.MATRICULA_USUARIO);
        nomeTxt.setText(User.NOME_USUARIO);
        DataHora dataHora = new DataHora();
        defaults();
        microTxt.requestFocus();
        lblMedia.setText("OLÁ! SEJA BEM VINDO!");
        lblMedia.setForeground(Color.WHITE);
    }
    
  
    public void defaults() {
        
           new Thread() {
             public void run() {
                while (true){
            
           if(microTxt.getText().toUpperCase().length() > 0){
               conf();
            }         
                          
            try{
             Thread.sleep(30000);
            
            }catch(Exception e){
             e.printStackTrace();  
            }
           } 
          }
         }.start(); 
      }
       
    
   
    
      public void zerarP1(){
      System.out.println("Zera Produção ");
      priTxt.setText("");
      segTxt.setText("");
      terTxt.setText("");
      quaTxt.setText("");
      quiTxt.setText("");
      sexTxt.setText("");
      setTxt.setText("");
      oitTxt.setText("");
      nonTxt.setText("");
      decTxt.setText("");
      decpTxt.setText("");
      totalTxt.setText("");
      mediaTxt.setText("");
      lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource(""))); 
      lblMedia.setText("OLÁ! SEJA BEM VINDO!");
      lblMedia.setForeground(Color.WHITE);
      }
     
      public void zerarP(){
      priTxt.setText("");
      segTxt.setText("");
      terTxt.setText("");
      quaTxt.setText("");
      quiTxt.setText("");
      sexTxt.setText("");
      setTxt.setText("");
      oitTxt.setText("");
      nonTxt.setText("");
      decTxt.setText("");
      decpTxt.setText("");
      totalTxt.setText("");
      mediaTxt.setText("");
      }
     
    
    public void Media() throws IOException{
        
      // Calculo da meta pelo micro da conferente
      List<Micro> micro = MicroJpaDAO.getInstance().findByMicro(microTxt.getText());
      double meta = 0;
      for(int b = 0; b < micro.size(); b ++ ){
          String TempMeta = "";
          TempMeta = micro.get(b).getMeta().replace("", "");
          meta = Double.parseDouble(TempMeta);
      
      String M = "";
      M = microTxt.getText().toUpperCase();
      double media = Integer.parseInt(mediaTxt.getText());
      
      if(M.length() > 0){
          metaMicroTxt.setText(TempMeta);
          double porcen = media/meta;
          DecimalFormat df = new DecimalFormat ("#,##0.00%");
          lblPorcentagem.setText(df.format(porcen));
          System.out.println("double " + porcen);
          if( porcen  < 0.20){
          System.out.println("10");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/10%.png")));     
          }
          if(porcen > 0.20){
          System.out.println("20");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/20%.png")));     
          }    
          if(porcen > 0.20){
          System.out.println("20");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/20%.png"))); 
          }
          if(porcen > 0.30){
          System.out.println("30");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/30%.png")));     
          }
          if(porcen  > 0.40){
          System.out.println("40");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/40%.png")));     
          }   
          if(porcen > 0.50){
          System.out.println("50");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/50%.png")));     
          if(porcen > 0.60){
          System.out.println("60");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/60%.png")));     
          if(porcen > 0.70){
          System.out.println("70");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/70%.png")));     
          if(porcen > 0.80){
          System.out.println("80");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/80%.png")));     
          if(porcen > 0.90){
          System.out.println("90");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/90%.png")));     
          if(porcen > 0.98){
          System.out.println("99");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/99%.png")));     
          if(porcen >= 1.00){
          System.out.println("99");
          lblMedia.setText("");
          lblMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/100%.png")));     
          }
          }
          }
          }
          }
          }
          }
         }
       DecimalFormat df = new DecimalFormat ("###,###,###,###,###");
       mediaTxt.setText(df.format(media));
       }
       dados();  
     }  
   

    public void dados(){
       // remove e inclui a produção individual para analise do lider 
       DataHora dataHora = new DataHora();
       try{
       System.out.println("remover");
       List<Monitoramento> mt = MonitoramentoJpaDAO.getInstance().findByCodigo(codigoTxt.getText());
       for(int b = 0; b < mt.size(); b ++ ){
       int id = mt.get(b).getId();
       MonitoramentoJpaDAO.getInstance().removeById(id);
       }
     System.out.println("inserir");
     Monitoramento mto = new Monitoramento();   
     
     mto.setMicro(microTxt.getText());
     mto.setCodigo(codigoTxt.getText());
     mto.setNome(nomeTxt.getText());
     mto.setTotal(totalTxt.getText());
     mto.setMedia(mediaTxt.getText());
     mto.setPorcen(lblPorcentagem.getText());
     mto.setHora(dataHora.Hora());

     MonitoramentoJpaDAO.getInstance().merge(mto);
     
     }catch(Exception ex){
       ex.printStackTrace();
     }    
    }
    
     public void conf(){
     // Atualização da produção    
     System.out.println("Atualiza a produtção frameP");    
     zerarP1();
     List<Pln0096r> pln = Pln0096rJpaDAO.getInstance().findByCodigo(codigoTxt.getText());
      int codigo = 0;
      String nome = "0";
      int h1 = 0;
      int h2 = 0;
      int h3 = 0;
      int h4 = 0;
      int h5 = 0;
      int h6 = 0;
      int h7 = 0;
      int h8 = 0;
      int h9 = 0;
      int h10 = 0;
      int h11 = 0;
      int h01 = 0;
      int h02 = 0;
      int h03 = 0;
      int h04 = 0;
      int h05 = 0; 
      int h06 = 0;
      int h07 = 0;
      int h08 = 0;
      int h09 = 0;
      int h010 = 0;
      int h011 = 0;           
        
       for (int b = 0; b < pln.size(); b++) {
          
            String codigoTemp = "0";
            codigoTemp = pln.get(b).getCodigo().replace(" ", "");
            codigo = Integer.parseInt(codigoTemp);
            //System.out.println("Mtricula " + codigo);
           
            try{
                if(Integer.toString(codigo).equals(codigoTxt.getText())){ 
                //System.out.println(" inicio");
                
                
                String nomeTemp = "0";
                nomeTemp = pln.get(b).getNome().replace(" ", "");
                nome = (nomeTemp);
                    System.out.println("Conferente: " + nome);
               
                if( pln.get(b).getH1().length() > 0){
                String tempH1 = "0";
                tempH1 = pln.get(b).getH1().replace(" ", "");
                tempH1 = tempH1.replace(".", "");
                if(tempH1.trim().length() > 0){
                h1 = Integer.parseInt(tempH1);
                double num = h1;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                priTxt.setText(df.format(num));
                System.out.println("h1 " + h1);
                if(num > m){
                h01 = 1;   
                //System.out.println("h01 " + h01);
                }
                }
                }
                if(pln.get(b).getH2().length() > 0){
                String tempH2 = "0";
                tempH2 = pln.get(b).getH2().replace(" ", "");
                tempH2 = tempH2.replace(".", "");
                if(tempH2.trim().length() > 0){
                h2 = Integer.parseInt(tempH2);
                double num = h2;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                segTxt.setText(df.format(num));
                System.out.println("h2 " + h2);  
                if(num > m){
                h02 = 1;   
                }
                }
                }
                if(pln.get(b).getH3().length() > 0){
                String tempH3 = "0";
                tempH3 = pln.get(b).getH3().replace(" ", "");
                tempH3 = tempH3.replace(".", "");
                if(tempH3.trim().length() >0){
                h3 = Integer.parseInt(tempH3);
                double num = h3;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                terTxt.setText(df.format(num));
                System.out.println("h3 " + h3);
                if(num > m){
                h03 = 1;   
                }
                }
                }
                if(pln.get(b).getH4().length() > 0){    
                String tempH4 = "0";
                tempH4 = pln.get(b).getH4().replace(" ", "");
                tempH4 = tempH4.replace(".", "");
                if(tempH4.trim().length() >0){
                h4 = Integer.parseInt(tempH4);
                double num = h4;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                quaTxt.setText(df.format(num));
                System.out.println("h4 " + h4);
                if(num > m){
                h04 = 1;   
                }
                }
                }
                if(pln.get(b).getH5().length() > 0){        
                String tempH5 = "0";
                tempH5 = pln.get(b).getH5().replace(" ", "");
                tempH5 = tempH5.replace(".", "");
                if(tempH5.trim().length() > 0){
                h5 = Integer.parseInt(tempH5);
                double num = h5;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                quiTxt.setText(df.format(num));
                System.out.println("h5 " + h5);
                if(num > m){
                h05 = 1;   
                }
                }
                }
                if(pln.get(b).getH6().length() > 0){  
                String tempH6 = "0";
                tempH6 = pln.get(b).getH6().replace(" ", "");
                tempH6 = tempH6.replace(".", "");
                if(tempH6.trim().length() > 0){
                h6 = Integer.parseInt(tempH6);
                double num = h6;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                sexTxt.setText(df.format(num));
                System.out.println("h6 " + h6);
                if(num > m){
                h06 = 1;   
                }
                }
                }
                if(pln.get(b).getH7().length() > 0 ){ 
                String tempH7 = "0";
                tempH7 = pln.get(b).getH7().replace(" ", "");
                tempH7 = tempH7.replace(".", "");
                if(tempH7.trim().length() > 0 ){
                h7 = Integer.parseInt(tempH7);
                double num = h7;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                setTxt.setText(df.format(num));
                System.out.println("h7 " + h7);
                if(num > m){
                h07 = 1;   
                }
                }
                }  
                if(pln.get(b).getH8().length() > 0){  
                String tempH8 = "0";
                tempH8 = pln.get(b).getH8().replace(" ", "");
                tempH8 = tempH8.replace(".", "");
                if(tempH8.trim().length() >0){
                h8 = Integer.parseInt(tempH8);  
                double num = h8;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                oitTxt.setText(df.format(num));
                System.out.println("h8 " + h8);
                if(num > m){
                h08 = 1;   
                }
                }
                }
                if(pln.get(b).getH9().length() > 0){
                String tempH9 = "0";
                tempH9 = pln.get(b).getH9().replace(" ", "");
                tempH9 = tempH9.replace(".", "");
                if(tempH9.trim().length() > 0){
                h9 = Integer.parseInt(tempH9);
                double num = h9;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                nonTxt.setText(df.format(num));
                System.out.println("h9 " + h9);
                if(num > m){
                h09 = 1;   
                }
                }
                }
                if(pln.get(b).getH10().length() > 0){
                String tempH10 = "0";
                tempH10 = pln.get(b).getH10().replace(" ", "");
                tempH10 = tempH10.replace(".", "");
                if(tempH10.trim().length() > 0){
                h10 = Integer.parseInt(tempH10);
                double num = h10;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                decTxt.setText(df.format(num));
                System.out.println("h10 " + h10);
                if(num > m){
                h010 = 1;   
                }
                }
                }
                if(pln.get(b).getH11().length() > 0){
                String tempH11 = "0";
                tempH11 = pln.get(b).getH11().replace(" ", "");
                tempH11 = tempH11.replace(".", "");
                if(tempH11.trim().length() > 0){
                h11 = Integer.parseInt(tempH11);
                double num = h11;
                double m = 100;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                decpTxt.setText(df.format(num));
                //System.out.println("h11 " + h11);
                if(num > m){
                h011 = 1;   
                }
                }
                }
                int total = 0;
                int hT = 0;
                int media = 0;
                total =  h1 + h2 + h3 + h4 + h5 + h6 + h7 + h8 + h9 + h10 + h11 ;
                System.out.println("Total  " + total);
                hT = h01 + h02 + h03 + h04 + h05 + h06 + h07 + h08 + h09 + h010 + h011;
                System.out.println("Horas T  " + hT);
                double num = total;
                DecimalFormat df = new DecimalFormat("###,###,###,###,###");
                totalTxt.setText(df.format(num));
                if(hT > 0){
                media = total / hT; 
                mediaTxt.setText(Integer.toString(media));
                
                
                System.out.println("Media " + media);               
                lblHora();
                atz();  
                Media();   
                }                
               }
            }catch(Exception e) {
                System.out.println("sem produção!");
        }
      }
    }
     
     public void atz(){
        System.out.println("atz");
        lblData.setText("");
        lblHora.setText("");
        List<Atz> atz = AtzJpaDAO.getInstance().findAll();
        for(int a = 0; a < atz.size(); a ++){
                String data = "";
                String hora = "";
                 
                String tempData = "0";
                tempData = atz.get(a).getData().replace(" ", "");
                tempData = tempData.replace(".", "");
                data = tempData;
                 System.out.println("Data " + data);
                lblData.setText(data);
                
                String tempHora = "0";
                tempHora = atz.get(a).getHora().replace(" ", "");
                tempHora = tempHora.replace(".", "");
                hora = tempHora;
                    System.out.println("Hora" + hora);
                lblHora.setText(hora);
                }
        }
     
     
     public void lblHora(){
          System.out.println("atz");
           List<Pln0096r> atz = Pln0096rJpaDAO.getInstance().findByCodigo("CODIGO");
           for(int a = 0; a < atz.size(); a ++){
              
                String h1 = "";
                String h2 = "";
                String h3 = "";
                String h4 = "";
                String h5 = "";
                String h6 = "";
                String h7 = "";
                String h8 = "";
                String h9 = "";
                String h10 = "";
                String h11 = "";
                
               
                String tempH1 = "0";
                tempH1 = atz.get(a).getH1().replace(" ", "");
                tempH1 = tempH1.replace(".", "");
                h1 = tempH1;
                System.out.println("lblH1 " + h1);
                lblH1.setText(h1);
              
                String tempH2 = "0";
                tempH2 = atz.get(a).getH2().replace(" ", "");
                tempH2 = tempH2.replace(".", "");
                h2 = tempH2;
                System.out.println("lblH2 " + h2);
                lblH2.setText(h2);
                
                String tempH3 = "0";
                tempH3 = atz.get(a).getH3().replace(" ", "");
                tempH3 = tempH3.replace(".", "");
                h3 = tempH3;
                System.out.println("lblH3 " + h3);
                lblH3.setText(h3);
                
                String tempH4 = "0";
                tempH4 = atz.get(a).getH4().replace(" ", "");
                tempH4 = tempH4.replace(".", "");
                h4 = tempH4;
                System.out.println("lblH4 " + h4);
                lblH4.setText(h4);
                
                String tempH5 = "0";
                tempH5 = atz.get(a).getH5().replace(" ", "");
                tempH5 = tempH5.replace(".", "");
                h5 = tempH5;
                System.out.println("lblH5 " + h5);
                lblH5.setText(h5);
                
                String tempH6 = "0";
                tempH6 = atz.get(a).getH6().replace(" ", "");
                tempH6 = tempH6.replace(".", "");
                h6 = tempH6;
                System.out.println("lblH6 " + h6);
                lblH6.setText(h6);
                
                String tempH7 = "0";
                tempH7 = atz.get(a).getH7().replace(" ", "");
                tempH7 = tempH7.replace(".", "");
                h7 = tempH7;
                System.out.println("lblH7 " + h7);
                lblH7.setText(h7);
                
                String tempH8 = "0";
                tempH8 = atz.get(a).getH8().replace(" ", "");
                tempH8 = tempH8.replace(".", "");
                h8 = tempH8;
                System.out.println("lblH8 " + h8);
                lblH8.setText(h8);
                
                String tempH9 = "0";
                tempH9 = atz.get(a).getH9().replace(" ", "");
                tempH9 = tempH9.replace(".", "");
                h9 = tempH9;
                System.out.println("lblH9 " + h9);
                lblH9.setText(h9);
                
                String tempH10 = "0";
                tempH10 = atz.get(a).getH10().replace(" ", "");
                tempH10 = tempH10.replace(".", "");
                h10 = tempH10;
                System.out.println("lblH10 " + h10);
                lblH10.setText(h10);
                
                 String tempH11 = "0";
                tempH11 = atz.get(a).getH11().replace(" ", "");
                tempH11 = tempH11.replace(".", "");
                h11 = tempH11;
                System.out.println("lblH11 " + h11);
                lblH11.setText(h11);
                }
           }
     
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblH2 = new javax.swing.JLabel();
        quaTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblH3 = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();
        quiTxt = new javax.swing.JTextField();
        lblH4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        sexTxt = new javax.swing.JTextField();
        lblH5 = new javax.swing.JLabel();
        mediaTxt = new javax.swing.JTextField();
        decTxt = new javax.swing.JTextField();
        lblH6 = new javax.swing.JLabel();
        lblH11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblH7 = new javax.swing.JLabel();
        segTxt = new javax.swing.JTextField();
        lblH8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        setTxt = new javax.swing.JTextField();
        decpTxt = new javax.swing.JTextField();
        lblH1 = new javax.swing.JLabel();
        lblH9 = new javax.swing.JLabel();
        microTxt = new javax.swing.JTextField();
        lblH10 = new javax.swing.JLabel();
        nonTxt = new javax.swing.JTextField();
        priTxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        terTxt = new javax.swing.JTextField();
        oitTxt = new javax.swing.JTextField();
        metaMicroTxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblMedia = new javax.swing.JLabel();
        lblPorcentagem = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JLabel();
        nomeTxt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.foreground"));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(18, 33, 71));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lblH2.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH2.setForeground(new java.awt.Color(255, 255, 255));
        lblH2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH2.setText("Hora 2");
        lblH2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        quaTxt.setEditable(false);
        quaTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        quaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quaTxt.setFocusable(false);
        quaTxt.setRequestFocusEnabled(false);

        jLabel15.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Total");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblH3.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH3.setForeground(new java.awt.Color(255, 255, 255));
        lblH3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH3.setText("Hora 3");
        lblH3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        totalTxt.setEditable(false);
        totalTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        totalTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalTxt.setFocusable(false);
        totalTxt.setRequestFocusEnabled(false);

        quiTxt.setEditable(false);
        quiTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        quiTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quiTxt.setFocusable(false);
        quiTxt.setRequestFocusEnabled(false);

        lblH4.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH4.setForeground(new java.awt.Color(255, 255, 255));
        lblH4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH4.setText("Hora 4");
        lblH4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Media");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        sexTxt.setEditable(false);
        sexTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        sexTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sexTxt.setFocusable(false);
        sexTxt.setRequestFocusEnabled(false);

        lblH5.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH5.setForeground(new java.awt.Color(255, 255, 255));
        lblH5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH5.setText("Hora 5");
        lblH5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mediaTxt.setEditable(false);
        mediaTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        mediaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mediaTxt.setFocusable(false);
        mediaTxt.setRequestFocusEnabled(false);

        decTxt.setEditable(false);
        decTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        decTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        decTxt.setFocusable(false);
        decTxt.setRequestFocusEnabled(false);

        lblH6.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH6.setForeground(new java.awt.Color(255, 255, 255));
        lblH6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH6.setText("Hora 6");
        lblH6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblH11.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH11.setForeground(new java.awt.Color(255, 255, 255));
        lblH11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH11.setText("Hora 11");
        lblH11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Conferente");

        lblH7.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH7.setForeground(new java.awt.Color(255, 255, 255));
        lblH7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH7.setText("Hora 7");
        lblH7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        segTxt.setEditable(false);
        segTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        segTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        segTxt.setFocusable(false);
        segTxt.setRequestFocusEnabled(false);

        lblH8.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH8.setForeground(new java.awt.Color(255, 255, 255));
        lblH8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH8.setText("Hora 8");
        lblH8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel18.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Meta");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        setTxt.setEditable(false);
        setTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        setTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        setTxt.setFocusable(false);
        setTxt.setRequestFocusEnabled(false);

        decpTxt.setEditable(false);
        decpTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        decpTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        decpTxt.setFocusable(false);
        decpTxt.setRequestFocusEnabled(false);

        lblH1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH1.setForeground(new java.awt.Color(255, 255, 255));
        lblH1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH1.setText("Hora 1");
        lblH1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblH9.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH9.setForeground(new java.awt.Color(255, 255, 255));
        lblH9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH9.setText("Hora 9");
        lblH9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        microTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        microTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        microTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                microTxtActionPerformed(evt);
            }
        });
        microTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                microTxtKeyReleased(evt);
            }
        });

        lblH10.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblH10.setForeground(new java.awt.Color(255, 255, 255));
        lblH10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH10.setText("Hora 10");
        lblH10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nonTxt.setEditable(false);
        nonTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        nonTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nonTxt.setFocusable(false);
        nonTxt.setRequestFocusEnabled(false);

        priTxt.setEditable(false);
        priTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        priTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priTxt.setFocusable(false);
        priTxt.setRequestFocusEnabled(false);
        priTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priTxtActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Micro");

        terTxt.setEditable(false);
        terTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        terTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        terTxt.setFocusable(false);
        terTxt.setRequestFocusEnabled(false);

        oitTxt.setEditable(false);
        oitTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        oitTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        oitTxt.setFocusable(false);
        oitTxt.setRequestFocusEnabled(false);

        metaMicroTxt.setEditable(false);
        metaMicroTxt.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        metaMicroTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        metaMicroTxt.setFocusable(false);
        metaMicroTxt.setRequestFocusEnabled(false);
        metaMicroTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metaMicroTxtActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Produção Atualizada:");

        lblData.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 0, 51));
        lblData.setText("...................");

        lblHora.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 0, 51));
        lblHora.setText("...............");

        jPanel2.setBackground(new java.awt.Color(18, 33, 71));

        lblMedia.setFont(new java.awt.Font("Lucida Fax", 1, 40)); // NOI18N
        lblMedia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblPorcentagem.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        lblPorcentagem.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPorcentagem, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        codigoTxt.setBackground(new java.awt.Color(11, 40, 72));
        codigoTxt.setFont(new java.awt.Font("Lucida Fax", 0, 1)); // NOI18N
        codigoTxt.setForeground(new java.awt.Color(255, 255, 255));
        codigoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        nomeTxt.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        nomeTxt.setForeground(new java.awt.Color(255, 255, 255));
        nomeTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/logo1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(microTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(metaMicroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(nomeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(219, 219, 219)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(priTxt)
                                    .addComponent(lblH1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(segTxt)
                                    .addComponent(lblH2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(terTxt)
                                    .addComponent(lblH3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(quaTxt)
                                    .addComponent(lblH4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(quiTxt)
                                    .addComponent(lblH5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sexTxt)
                                    .addComponent(lblH6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(setTxt)
                                    .addComponent(lblH7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(oitTxt)
                                    .addComponent(lblH8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nonTxt)
                                    .addComponent(lblH9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(decTxt)
                                    .addComponent(lblH10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(decpTxt)
                                    .addComponent(lblH11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalTxt)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mediaTxt)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(microTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(metaMicroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(lblData)
                            .addComponent(lblHora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblH1)
                            .addComponent(lblH2)
                            .addComponent(lblH3)
                            .addComponent(lblH4)
                            .addComponent(lblH5)
                            .addComponent(lblH6)
                            .addComponent(lblH7)
                            .addComponent(lblH8)
                            .addComponent(lblH9)
                            .addComponent(lblH10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(segTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(terTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nonTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(decTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mediaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblH11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(decpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void metaMicroTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metaMicroTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_metaMicroTxtActionPerformed

    private void priTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priTxtActionPerformed

    private void microTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_microTxtKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10){
            try {
                List<Micro> mc = MicroJpaDAO.getInstance().findByMicro(microTxt.getText().toUpperCase());
                for(int b = 0; b < mc.size(); b ++){

                    String comp = "";
                    String compTemp = "";
                    compTemp = mc.get(b).getMicro().replace(" ", " ");
                    compTemp = compTemp.replace("", "");
                    comp = compTemp;
                    if(comp.equals(microTxt.getText().toUpperCase())){
                        zerarP1();
                        conf();
                        codigoTxt.requestFocus();
                    }
                }
            }catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Nenhum computador selecionado!");

            }
        }
    }//GEN-LAST:event_microTxtKeyReleased

    private void microTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_microTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_microTxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMonitoramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMonitoramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMonitoramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMonitoramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMonitoramento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codigoTxt;
    public javax.swing.JTextField decTxt;
    public javax.swing.JTextField decpTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblH1;
    private javax.swing.JLabel lblH10;
    private javax.swing.JLabel lblH11;
    private javax.swing.JLabel lblH2;
    private javax.swing.JLabel lblH3;
    private javax.swing.JLabel lblH4;
    private javax.swing.JLabel lblH5;
    private javax.swing.JLabel lblH6;
    private javax.swing.JLabel lblH7;
    private javax.swing.JLabel lblH8;
    private javax.swing.JLabel lblH9;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMedia;
    private javax.swing.JLabel lblPorcentagem;
    private javax.swing.JTextField mediaTxt;
    private javax.swing.JTextField metaMicroTxt;
    private javax.swing.JTextField microTxt;
    private javax.swing.JLabel nomeTxt;
    public javax.swing.JTextField nonTxt;
    public javax.swing.JTextField oitTxt;
    public javax.swing.JTextField priTxt;
    public javax.swing.JTextField quaTxt;
    public javax.swing.JTextField quiTxt;
    public javax.swing.JTextField segTxt;
    public javax.swing.JTextField setTxt;
    public javax.swing.JTextField sexTxt;
    public javax.swing.JTextField terTxt;
    private javax.swing.JTextField totalTxt;
    // End of variables declaration//GEN-END:variables

   
}
