/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horas_extras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JFrame;

public class JFramePrinter implements Printable {

    private JFrame frame;

    public JFramePrinter(JFrame frame) {
        this.frame = frame;
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        frame.printAll(graphics);

        return Printable.PAGE_EXISTS;
    }

    public void imprimir() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);

        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                // Manejar excepción de impresión
            }
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de impresión");
        // Configurar el contenido del JFrame...

        JFramePrinter printer = new JFramePrinter(frame);
        printer.imprimir();
    }
}
