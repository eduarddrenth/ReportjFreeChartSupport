/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vectorprint.report.itext.style.stylers;

/*
 * #%L
 * ReportjFreeChartSupport
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2014 - 2015 VectorPrint
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

import com.vectorprint.VectorPrintRuntimeException;
import com.vectorprint.report.itext.style.parameters.ReportBindingHelper;
import com.vectorprint.report.jfree.ChartThemeBuilder;

/**
 *
 * @author Eduard Drenth at VectorPrint.nl
 */
public class ChartBindingHelper extends ReportBindingHelper {


   @Override
   public <T> T convert(String value, Class<T> clazz) {
      if (ChartThemeBuilder.class.equals(clazz)) {
         try {
            return (T) Class.forName(value).newInstance();
         } catch (ClassNotFoundException ex) {
            throw new VectorPrintRuntimeException(ex);
         } catch (InstantiationException ex) {
            throw new VectorPrintRuntimeException(ex);
         } catch (IllegalAccessException ex) {
            throw new VectorPrintRuntimeException(ex);
         }
      } else {
         return super.convert(value, clazz);
      }
   }

}
