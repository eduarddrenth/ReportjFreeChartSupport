package com.vectorprint.report.fxchart;

/*
 * #%L
 * VectorPrintReport4.0
 * %%
 * Copyright (C) 2012 - 2013 VectorPrint
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
//~--- non-JDK imports --------------------------------------------------------
import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfTemplate;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javax.swing.JFrame;

/**
 * Helper that can plot a JavaFX Scenes on a PdfContentByte.
 *
 * @author Eduard Drenth at VectorPrint.nl
 */
public class JavaFXHelper {

   public static Image getSceneImage(Scene scene, PdfContentByte contentByte, float opacity)
       throws BadElementException {

      // create PdfTemplate from PdfContentByte
      PdfTemplate template = contentByte.createTemplate((float) scene.getWidth(), (float) scene.getHeight());
      template.saveState();
      PdfGState pgs = new PdfGState();
      pgs.setFillOpacity(opacity);
      pgs.setStrokeOpacity(opacity);
      template.setGState(pgs);

      // create Graphics2D from PdfTemplate
      Graphics2D g2 = new PdfGraphics2D(template, (float) scene.getWidth(), (float) scene.getHeight());

      // setup the drawing area
      Rectangle2D r2D = new Rectangle2D.Double(0, 0, (float) scene.getWidth(), (float) scene.getHeight());

      JFXPanel panel = new ExtraGraphicsPanel(g2);
      panel.setScene(scene);

      JFrame frame = new JFrame();
      frame.setSize(Math.round((float) scene.getWidth()), Math.round((float) scene.getHeight()));
      frame.add(panel);
      frame.setVisible(true);

      // pass the Graphics2D and drawing area to JFreeChart
      g2.dispose();    // always dispose this

      frame.setVisible(false);

      template.restoreState();

      // create Image from PdfTemplate
      return Image.getInstance(template);
   }
}
