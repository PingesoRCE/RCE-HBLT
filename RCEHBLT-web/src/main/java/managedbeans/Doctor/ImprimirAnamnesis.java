/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.Doctor;

import cl.rcehblt.entities.Anamnesis2;
import cl.rcehblt.entities.Consulta;
import cl.rcehblt.entities.Diagnostico;
import cl.rcehblt.entities.Episodios;
import cl.rcehblt.entities.Muesta;
import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.Persona;
import cl.rcehblt.paciente.PacienteNegocioLocal;
import cl.rcehblt.persona.PersonaNegocioLocal;
import cl.rcehblt.sessionbeans.Anamnesis2FacadeLocal;
import cl.rcehblt.sessionbeans.ConsultaFacadeLocal;
import cl.rcehblt.sessionbeans.DiagnosticoFacadeLocal;
import cl.rcehblt.sessionbeans.EpisodiosFacadeLocal;
import cl.rcehblt.sessionbeans.MuestaFacadeLocal;
import cl.rcehblt.sessionbeans.PersonaFacadeLocal;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DevelUser
 */
@WebServlet(name = "ImprimirAnamnesis", urlPatterns = {"/doctor/ImprimirAnamnesis"})
public class ImprimirAnamnesis extends HttpServlet {
    @EJB
    private EpisodiosFacadeLocal episodiosFacade;
    @EJB
    private MuestaFacadeLocal muestaFacade;
    @EJB
    private DiagnosticoFacadeLocal diagnosticoFacade;
    @EJB
    private ConsultaFacadeLocal consultaFacade;

    @EJB
    private Anamnesis2FacadeLocal anamnesisFacade;

    @EJB
    private PacienteNegocioLocal pacienteNegocio;
    @EJB
    private PersonaNegocioLocal personaNegocio;

    @EJB
    private PersonaFacadeLocal personaFacade;

    private String institution = "Hospital Barros Luco";
    private String address = "José Miguel Carrera 3604, San Miguel";
    private String city = "Santiago";
    private String personName = "";
    private Integer rut;
    public Paciente paciente;
    private Anamnesis2 anamnesis;
    private Consulta consulta;
    private List<Muesta> signos;
    private List<Diagnostico> diagnosticos;
    private Episodios episodio;  
    private String patientName = "";
    private Integer patientRut = 0;
    private String patientFonasa = "";
    private String patientIsapre = "";
    private String home = "";
    private String commune = "";
    private String region = "";
    private String phoneNumber = "";
    private String celularNumber = "";
    private String mail = "";
    Date aux = new Date();
    DateFormat dfDefault = DateFormat.getInstance();
    private String dateHour = dfDefault.format(aux);
    private String ges = "";
    private double peso;
    private double altura;
    private double presion;
    private double pulso;
    private double imc;
    private double temperatura;
    

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
        response.setContentType("application/pdf");
        String rut = request.getParameter("rut");
        String id = request.getParameter("id");
        Integer search = Integer.parseInt(rut);
        Integer idEp = Integer.parseInt(id);
        episodio = episodiosFacade.find(idEp);
        List<Persona> person = personaNegocio.busquedaPersonaRut(search);
        Persona personSelected;

        if (person.size() > 0) {
            System.out.println("La cantidad es:" + person.size());
            personSelected = person.get(0);
            System.out.println("La cantidad es:" + personSelected.getPersNombres());
            paciente = pacienteNegocio.busquedaPacienteIdPersona(personSelected.getIdPersona());
            signos = muestaFacade.searchByPatient(paciente);
            if (signos.size() > 0) {
                for (Muesta signo : signos) {
                    if(signo.getIdSvitales().getIdSvitales() == 1)
                        peso = signo.getValor();
                    if(signo.getIdSvitales().getIdSvitales() == 2)
                        altura  = signo.getValor();
                    if(signo.getIdSvitales().getIdSvitales() == 3)
                        temperatura = signo.getValor();
                    if(signo.getIdSvitales().getIdSvitales() == 5)
                        presion = signo.getValor();
                    if(signo.getIdSvitales().getIdSvitales() == 9)
                        pulso = signo.getValor();
                    if(signo.getIdSvitales().getIdSvitales() == 17)
                        imc = signo.getValor();
                }
            }
            if(consultaFacade.searchByEpisodio(episodio).size() > 0)
                consulta = consultaFacade.searchByEpisodio(episodio).get(0);
            patientName = personSelected.getPersNombres() + " " + personSelected.getPersApepaterno() + " " + personSelected.getPersApematerno();
            patientRut = search;
            patientFonasa = "";
            patientIsapre = paciente.getPaciOtraprevision();
            home = personSelected.getPersDireccion();
            commune = paciente.getPersona().getIdComuna().getComuNombre();
            region = "";
            phoneNumber = personSelected.getPersTelefono();
            celularNumber = personSelected.getPersCelular();
            mail = personSelected.getPersEmail();
        }
        try {
            //style
            Font typeBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, 1);
            Font type = new Font(Font.FontFamily.TIMES_ROMAN, 10);
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
            p1 = new Paragraph(space, "ANAMNESIS", title);
            p1.setAlignment(Element.ALIGN_CENTER);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, "Hospital Barros Luco", subTitle2);
            p1.setAlignment(Element.ALIGN_CENTER);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            table.addCell(cellRow1);
            document.add(table);
            document.add(new Paragraph("\n"));

            //row 3
            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "ANTECEDENTES DEL PACIENTE", subTitle);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, "NOMBRE: " + patientName, type);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, "RUT: " + patientRut, type);
            p2 = new Paragraph(space, "PREVISION: " + paciente.getIdPrevision().getPreviNombre(), type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            p1 = new Paragraph(space, "COMUNA: " + commune, type);
            p2 = new Paragraph(space, "DOMICILIO: " + home, type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            p1 = new Paragraph(space, "TELÉFONO DE CONTACTO: " + paciente.getPersona().getPersTelcontacto(), type);
            p2 = new Paragraph(space, "CORREO: " + paciente.getPersona().getPersEmail(), type);
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
            document.add(table);
            document.add(new Paragraph("\n"));

            //row 4
            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "ANAMNESIS", subTitle);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, consulta.getMotivoConsulta(), type);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            document.add(table);
            document.add(new Paragraph("\n"));

            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "HISTORIA OBSTÉTRICA", subTitle);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, "F.U.R.: ", type);
            p2 = new Paragraph(space, "F.P.P.: ", type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            p1 = new Paragraph(space, "PARTOS: ", type);
            p2 = new Paragraph(space, "ABORTOS: ", type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            p1 = new Paragraph(space, "FECHA ÚLTIMO PARTO: ", type);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            document.add(table);
            document.add(new Paragraph("\n"));

            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "EXÁMEN FÍSICO", subTitle);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, "PRESIÓN ARTERIAL: " +presion, type);
            p2 = new Paragraph(space, "TEMPERATURA: "+temperatura, type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            p1 = new Paragraph(space, "PULSO: " + pulso, type);
            p2 = new Paragraph(space, "PESO: "+peso, type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            p1 = new Paragraph(space, "TALLA: "+ altura, type);
            p2 = new Paragraph(space, "I.M.C.: "+imc, type);
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
            document.add(table);
            document.add(new Paragraph("\n"));

            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "EXÁMEN OBSTÉTRICO", subTitle);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, "A.U.: ", type);
            p2 = new Paragraph(space, "L.C.F.: ", type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            p1 = new Paragraph(space, "D.U.: ", type);
            p2 = new Paragraph(space, "PRESENTACIÓN: ", type);
            cellRow1 = new PdfPCell(p1);
            cellRow2 = new PdfPCell(p2);
            formatCellBorder(cellRow1, 20);
            formatCellBorder(cellRow2, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow2.setBorderWidthRight(1);
            if (1==0) {
                table.addCell(cellRow1);
                table.addCell(cellRow2);
                p1 = new Paragraph(space, "POSICIÓN: ", type);
                p2 = new Paragraph(space, "CONSISTENCIA: ", type);
                cellRow1 = new PdfPCell(p1);
                cellRow2 = new PdfPCell(p2);
                formatCellBorder(cellRow1, 20);
                formatCellBorder(cellRow2, 20);
                cellRow1.setBorderWidthLeft(1);
                cellRow2.setBorderWidthRight(1);
                table.addCell(cellRow1);
                table.addCell(cellRow2);
                p1 = new Paragraph(space, "BORRAMIENTO: ", type);
                p2 = new Paragraph(space, "DILATACION: ", type);
                cellRow1 = new PdfPCell(p1);
                cellRow2 = new PdfPCell(p2);
                formatCellBorder(cellRow1, 20);
                formatCellBorder(cellRow2, 20);
                cellRow1.setBorderWidthLeft(1);
                cellRow2.setBorderWidthRight(1);
                table.addCell(cellRow1);
                table.addCell(cellRow2);
                p1 = new Paragraph(space, "PLANO: ", type);
                p2 = new Paragraph(space, "MEMBRANAS: ", type);
                cellRow1 = new PdfPCell(p1);
                cellRow2 = new PdfPCell(p2);
                formatCellBorder(cellRow1, 20);
                formatCellBorder(cellRow2, 20);
                cellRow1.setBorderWidthLeft(1);
                cellRow2.setBorderWidthRight(1);
            }
            cellRow1.setBorderWidthBottom(1);
            cellRow2.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            table.addCell(cellRow2);
            document.add(table);
            document.add(new Paragraph("\n"));

            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "RESUMEN PATOLOGÍAS MATERNAS", subTitle);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, "PATOLOGÍAS: ", type);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            document.add(table);
            document.add(new Paragraph("\n"));

            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "DIAGNOSTICOS", subTitle);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, "Este es un diagnostico", type);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            document.add(table);
            document.add(new Paragraph("\n"));

            table = new PdfPTable(2);
            table.setWidthPercentage(100);
            p1 = new Paragraph(space, "INDICACIONES", subTitle);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthTop(1);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
            table.addCell(cellRow1);
            p1 = new Paragraph(space, "Estas son indicaciones", type);
            cellRow1 = new PdfPCell(p1);
            cellRow1.setColspan(2);
            formatCellBorder(cellRow1, 20);
            cellRow1.setBorderWidthLeft(1);
            cellRow1.setBorderWidthRight(1);
            cellRow1.setBorderWidthBottom(1);
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
