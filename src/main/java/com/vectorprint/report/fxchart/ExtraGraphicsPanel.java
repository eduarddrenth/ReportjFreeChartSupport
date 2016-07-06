/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vectorprint.report.fxchart;

import java.awt.Graphics;
import javafx.embed.swing.JFXPanel;

/**
 *
 * @author Eduard Drenth at VectorPrint.nl
 */
class ExtraGraphicsPanel extends JFXPanel {

   private final Graphics extraGraphics;

   public ExtraGraphicsPanel(Graphics extraGraphics) {
      this.extraGraphics = extraGraphics;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      super.paintComponent(extraGraphics);
   }

}
