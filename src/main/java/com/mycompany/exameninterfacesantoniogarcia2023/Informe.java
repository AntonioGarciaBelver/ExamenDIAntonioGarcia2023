package com.mycompany.exameninterfacesantoniogarcia2023;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Antonio y Loren
 */
public class Informe {

    public static void showReport() throws JRException, ClassNotFoundException, SQLException {
        String report = "";
        HashMap hm = new HashMap();

        report = "NotaAlumnado.jasper";

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report,
                hm,
                JdbcUtil.getConnection()
        );

        JRViewer viewer = new JRViewer(jasperPrint);

        JFrame frame = new JFrame("Listado de alumnos");
        frame.setSize(800, 1000);
        frame.getContentPane().add(viewer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

        System.out.print("Done!");
    }

    public static void pdfReport() throws JRException, ClassNotFoundException, SQLException {
        String report = "";
        HashMap hm = new HashMap();

        report = "NotaAlumnado.jasper";

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report,
                hm,
                JdbcUtil.getConnection()
        );

        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput(report + ".pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();

        System.out.print("Done!");

    }
}
