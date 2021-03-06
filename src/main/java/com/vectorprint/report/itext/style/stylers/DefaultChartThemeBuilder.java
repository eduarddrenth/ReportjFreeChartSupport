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

import com.vectorprint.configuration.EnhancedMap;
import com.vectorprint.report.jfree.ChartThemeBuilder;
import org.jfree.chart.ChartTheme;
import org.jfree.chart.StandardChartTheme;

/**
 *
 * @author Eduard Drenth at VectorPrint.nl
 */
public class DefaultChartThemeBuilder implements ChartThemeBuilder {
   
   /**
    * returns a new instance of {@link StandardChartTheme}, does not use the settings to configure it.
    * @param settings
    * @return 
    */
   @Override
   public ChartTheme fromSettings(EnhancedMap settings) {
      return new StandardChartTheme("StandardChartTheme");
   }

}
