/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IPDGES;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import cl.rcehblt.entities.Consulta;
import cl.rcehblt.entities.Episodios;
import cl.rcehblt.entities.IpdGes;
import cl.rcehblt.entities.Patologia;
import cl.rcehblt.entities.Persona;
import cl.rcehblt.entities.RegistroClinico;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.rcehblt.sessionbeans.ConsultaFacadeLocal;
import cl.rcehblt.sessionbeans.EpisodiosFacadeLocal;
import cl.rcehblt.sessionbeans.IpdGesFacadeLocal;
import cl.rcehblt.sessionbeans.PersonaFacadeLocal;
import cl.rcehblt.sessionbeans.RegistroClinicoFacadeLocal;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class IPD extends HttpServlet {

    @EJB
    private ConsultaFacadeLocal consultaFacade;
    @EJB
    private IpdGesFacadeLocal ipdGESFacade;
    @EJB
    private EpisodiosFacadeLocal episodioFacade;
    @EJB
    private RegistroClinicoFacadeLocal registroFacade;
    @EJB
    private PersonaFacadeLocal personaFacade;
    
    private String healthService = "Servicio de salud";
    private String speciality = "Especialidad";
    private String establishment = "Establecimiento";
    private String unit = "unidad";
    
    private String clinicalHistory;
    private String patientName;
    private String sexo;
    private int age;
    private Integer Rut;
    private Date bornDate;
    
    private String augeProblem;
    private String augeSubProblem;
    private String diagnosis;
    private String diagnosticBasics;
    private String treatment;
    private Boolean isGes;
    private Date deadline;

    
    private String professionalName = "Joel";
    private Integer professionalRut = 17409487;

        

    Date date = new Date();
    DateFormat dfDateInstance = DateFormat.getDateInstance();

    int numberFolio;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idGES = request.getParameter("id");
        IpdGes formulario = ipdGESFacade.searchById(Integer.parseInt(idGES)).get(0);
        numberFolio = Integer.parseInt(idGES);
        augeProblem = formulario.getProblemaauge();
        augeSubProblem = formulario.getSubproblemaauge();
        diagnosis = formulario.getDiagnostico();
        diagnosticBasics = formulario.getFundamentodiagnostico();
        treatment = formulario.getTratamientoind();
        isGes = formulario.getConfirmages();
        deadline = formulario.getFechalimite();
        Consulta consulta = consultaFacade.find(formulario.getConsultaid().getConsultaid());
        Episodios episodio = episodioFacade.find(consulta.getEpisodioid().getEpisodioid());
        RegistroClinico registro = registroFacade.find(episodio.getRegistroclinicoid().getRegistroclinicoid());
        Persona persona = personaFacade.find(registro.getIdPersona().getIdPersona());
        clinicalHistory = registro.getRegistroclinicoid().toString();
        patientName = persona.getPersNombres() + " " + persona.getPersApepaterno() + " " + persona.getPersApematerno();
        sexo = "F";
        bornDate = persona.getPersFnacimiento();
        Calendar today = Calendar.getInstance();
        Calendar born = Calendar.getInstance();
        born.setTime(bornDate);
        age = today.get(Calendar.YEAR) - born.get(Calendar.YEAR);
        Rut = persona.getPersRut();
        
        response.setContentType("application/pdf");

        try {
            //style
            Font typeBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,1);
            Font type = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font title = new Font(Font.FontFamily.TIMES_ROMAN, 15, 1);
            Font subTitle = new Font(Font.FontFamily.TIMES_ROMAN, 13, 1);
            Font subTitle2 = new Font(Font.FontFamily.TIMES_ROMAN, 10, 1);
            float space = (float) 20;

            Document document = new Document();
            document.setPageSize(PageSize.LETTER);
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            //General
            PdfPTable table;
            Paragraph p1;
            Paragraph p2;
            PdfPCell cellRow1;
            PdfPCell cellRow2;

            //row: 1
            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "Informe de Proceso Diagnóstico", title);
            p1.setAlignment(Element.ALIGN_CENTER);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 40);
            table.addCell(cellRow1);
            document.add(table);

            //row: 2         
            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "Fecha: " + dfDateInstance.format(date), type);
            p2 = new Paragraph(space, "Folio: " + numberFolio, type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            document.add(table);
            document.add(new Paragraph("\n"));

            //row: 3
            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "Servicio de Salud: " + healthService, type);
            p2 = new Paragraph(space, "Establecimiento: " + establishment, type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthTop(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            p1 = new Paragraph(space, "Especialidad: " + speciality, type);
            p2 = new Paragraph(space, "Unidad: " + unit, type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthBottom(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthBottom(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            document.add(table);
            document.add(new Paragraph("\n"));
            //row: 4
            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "Datos del Paciente", subTitle);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            p1 = new Paragraph("Historia clínica: " + clinicalHistory, type);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, "Nombre: " + patientName, type);
            p2 = new Paragraph(space, "Rut: " + Rut, type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            p1 = new Paragraph(space,"Sexo: " + sexo, type);
            p2 = new Paragraph(space,"Fecha de nacimiento: " + dfDateInstance.format(bornDate), type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            p1 = new Paragraph(space,"Edad: " + age, type);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            document.add(table);
            document.add(new Paragraph("\n"));
            
            //row 5
//           
            p1 = new Paragraph(space, "Datos Clínicos", subTitle);
            document.add(p1);

            p1 = new Paragraph(space, "* Sólo para caso AUGE", subTitle2);
            document.add(p1);

            p1 = new Paragraph(space, "Problema de salud AUGE:", typeBold);
            document.add(p1);

            p1 = new Paragraph(augeProblem, type);
            p1.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p1);

            p1 = new Paragraph("", type);
            document.add(p1);
            if(isGes){
                p1 = new Paragraph(space, "¿Confirma que el diagnóstico pertenece al sistema AUGE? " + "(X)SI ()NO", typeBold);
            }else{
                p1 = new Paragraph(space, "¿Confirma que el diagnóstico pertenece al sistema AUGE? " + "()SI (X)NO", typeBold);                
            }
            document.add(p1);
            p1 = new Paragraph(" ");
            document.add(p1);

            p1 = new Paragraph(" ");
            document.add(p1);
            p1 = new Paragraph(space, "SubProblema Auge:", typeBold);
            document.add(p1);

            p1 = new Paragraph(augeSubProblem, type);
            p1.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p1);

            p1 = new Paragraph(" ");
            document.add(p1);
            p1 = new Paragraph(space, "Diagnóstico:", typeBold);
            document.add(p1);

            p1 = new Paragraph(diagnosis, type);
            p1.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p1);

            p1 = new Paragraph(" ");
            document.add(p1);
            p1 = new Paragraph(space, "Fundamentos de diagnóstico:", typeBold);
            document.add(p1);

            p1 = new Paragraph(diagnosticBasics, type);
            p1.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p1);

            p1 = new Paragraph(" ");
            document.add(p1);
            p1 = new Paragraph(space, "Tratamiento e Indicaciones:", typeBold);
            document.add(p1);

            p1 = new Paragraph(treatment, type);
            p1.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p1);

            p1 = new Paragraph(" ");
            document.add(p1);
            p1 = new Paragraph(space, "El tratamiento deberá iniciarse a más tardar el: " + dfDateInstance.format(deadline), typeBold);
            document.add(p1);

            document.add(new Paragraph(" "));
            
//row: 6
            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "Datos del Profesional", subTitle);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            p1 = new Paragraph( "Nombre: " + professionalName, type);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            table.addCell(cellRow1);
            p1 = new Paragraph( "Rut: " + professionalRut, type);
            p2 = new Paragraph("Firma del médico", type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);            
            cellRow1.setBorderWidthBottom(1);
            cellRow2.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            table.addCell(cellRow1);
            document.add(table);
            document.close();
        } catch (DocumentException de) {
            throw new IOException(de.getMessage());
        }

    }

    private void formatCellBorder(PdfPCell cell, int h) {
        cell.setFixedHeight(h);
        cell.setBorder(0);
    }
}
