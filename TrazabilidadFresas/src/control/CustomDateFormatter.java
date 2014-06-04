/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.jdesktop.swingx.renderer.FormatStringValue;

/**
 *
 * @author fredy
 */
public class CustomDateFormatter {
    
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
    private FormatStringValue stringValue = new FormatStringValue(simpleDateFormat);
    
    public String formatDate(Date fecha) {
        return simpleDateFormat.format(fecha);
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public FormatStringValue getStringValue() {
        return stringValue;
    }

    public void setStringValue(FormatStringValue stringValue) {
        this.stringValue = stringValue;
    }
    
}
