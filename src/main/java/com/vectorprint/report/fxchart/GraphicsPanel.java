/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vectorprint.report.fxchart;

import java.awt.Graphics;
import java.util.Observer;
import javafx.embed.swing.JFXPanel;

/**
 *
 * @author Eduard Drenth at VectorPrint.nl
 */
class GraphicsPanel extends JFXPanel {

   private final Graphics graphics;
   private final Observer observer;

   public GraphicsPanel(Graphics graphics, Observer observer) {
      this.graphics = graphics;
      this.observer = observer;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(graphics);
   }

   @Override
   public void paint(Graphics g) {
      super.paint(g);
      observer.update(null, g);
   }

}
