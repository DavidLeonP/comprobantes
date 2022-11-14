package com.aplicaciones13.ride.guiaremision.impresion;

import com.aplicaciones13.sri.contenedores.TablasSRI;
import com.aplicaciones13.sri.contenedores.TotalDocumento;
import com.aplicaciones13.impresion.Elemento;
import com.aplicaciones13.impresion.ImpresionBaseElementos;
import com.aplicaciones13.ride.guiaremision.Detalle;
import com.aplicaciones13.ride.guiaremision.GuiaRemision;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto para crear un documento de guiaRemision.
 *
 * @author o.velez@13aplicaciones.com
 *
 */
public class ImpresionElementosGuiaRemision extends ImpresionBaseElementos {

	private static final String TXT_3_1 = "Guia Remisi\u00f3n";

	private static final String[] TXT_6_1 = {
			"Raz\u00f3n Social (Transportista)", "RUC/CI.", "Placa", "Direcci\u00f3n Partida",
			"Fecha Inicio Transorte",
			"Fecha Fin Transorte", "RISE"
	};

	private static final String[] TXT_7_10 = {
			"Documento Sustento ", "N\u00famero ", "Fecha Emision ", "N\u00famero autorizado ",
			"Motivo de Traslado "
	};

	private static final String[] TXT_7_11 = { "Raz\u00f3n Social (Destinatario)", "Identificaci\u00f3n",
			"Direccion" };

	private static final String[] TXT_7_12 = {
			"Documento Aduanero \u00fanico", "C\u00f3d. Establecimiento destino ", "Ruta" };

	private static final String[] TXT_7_2 = { "Cod.", "Cod. Alt.", "Descripci\u00f3n", "Cantidad" };

	private static final String TXT_10_1 = "Informaci\u00f3n Adicional";

	private DatosGuiaRemision datosGuiaRemision;
	List<TotalDocumento> totales;

	/**
	 * Metodo para generar el panel superior en un formato semejante al SRI.
	 *
	 */
	@Override
	protected synchronized void elemento10() {
		this.getElementosComunes().encabezado(
				getDatosGuiaRemision().getPathLogo(),
				getDatosGuiaRemision().getGuiaRemisionXML().getInfoTributaria().getRazonSocial(),
				getDatosGuiaRemision().getGuiaRemisionXML().getInfoTributaria().getDirMatriz(),
				getDatosGuiaRemision().getGuiaRemisionXML().getInfoGuiaRemision()
						.getDirEstablecimiento(),
				getDatosGuiaRemision().getGuiaRemisionXML().getInfoGuiaRemision()
						.getContribuyenteEspecial(),
				getDatosGuiaRemision().getGuiaRemisionXML().getInfoGuiaRemision()
						.getObligadoContabilidad(),
				getDatosGuiaRemision().getGuiaRemisionXML().getInfoTributaria().getRuc(),
				TXT_3_1,
				getDatosGuiaRemision().getGuiaRemisionXML().getInfoTributaria().getEstab()
						+ "-" +
						getDatosGuiaRemision().getGuiaRemisionXML().getInfoTributaria()
								.getPtoEmi()
						+ "-" +
						getDatosGuiaRemision().getGuiaRemisionXML().getInfoTributaria()
								.getSecuencial(),
				getDatosGuiaRemision().getClaveAccesoAutorizacion(),
				getDatosGuiaRemision().getNumeroAutorizacion(),
				getDatosGuiaRemision().getFechaAutorizacion(),
				getDatosGuiaRemision().getAmbienteAutorizacion(),
				getDatosGuiaRemision().getEmisionAutorizacion(),
				getDatosGuiaRemision().isOffline());
	}

	/**
	 * Metodo para escribir la informacion del Transportista.
	 *
	 */
	@Override
	protected synchronized void elemento11() {
		getElementosComunes().espacios(2);

		informacionTransportista();

		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(100f);
		PdfPCell pdfPCell = getForm().escribeCelda();
		pdfPCell.setBorder(Rectangle.BOX);

		table.addCell(pdfPCell);

		try {
			getDocumento().add(table);
		} catch (DocumentException e) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
		}
	}

	/**
	 * Metodo para imprimir el detalle de la guiaRemision
	 *
	 */
	@Override
	protected synchronized void elemento12() {
		if (getDatosGuiaRemision().getGuiaRemisionXML().getDestinatarios() != null &&
				!getDatosGuiaRemision().getGuiaRemisionXML().getDestinatarios().getDestinatario()
						.isEmpty()) {
			for (int i = 0; i < getDatosGuiaRemision().getGuiaRemisionXML()
					.getDestinatarios()
					.getDestinatario()
					.size(); i++) {

				if (getPdfWriter().getVerticalPosition(true) < 176)
					getDocumento().newPage();

				getElementosComunes().espacios(2);

				PdfPTable table1 = new PdfPTable(1);
				table1.setWidthPercentage(100f);

				informacionDestinanario1(i);
				PdfPCell pdfPCell = getForm().escribeCelda();
				table1.addCell(pdfPCell);

				informacionDestinanario2(i);
				pdfPCell = getForm().escribeCelda();
				table1.addCell(pdfPCell);

				informacionDestinanario3(i);
				pdfPCell = getForm().escribeCelda();
				table1.addCell(pdfPCell);

				informacionDetalleEnvio(i);

				PdfPTable table = new PdfPTable(1);
				table.setWidthPercentage(100f);
				table.addCell(table1);
				pdfPCell = getTabla().escribeCelda();
				pdfPCell.setBorder(Rectangle.BOX);

				table.addCell(pdfPCell);

				try {
					getDocumento().add(table);
				} catch (DocumentException e) {
					Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
				}
			}
			if (getPdfWriter().getVerticalPosition(true) < 140)
				getDocumento().newPage();
		}
	}

	/**
	 * Metodo para agregar una imagen con la firma de un documento
	 *
	 * Esta firma no es legal ni optima para el SRI.
	 *
	 * @throws Exception
	 */
	@Override
	protected synchronized void elementoFirma() {
		String firmaGrafica = getDatosGuiaRemision().getPathFirmaGrafica();
		getElementosComunes().firmarGraficamente(firmaGrafica);
	}

	/**
	 * Metodo para crear la informacion del cliente
	 *
	 */
	private void informacionDestinanario1(int i) {
		TablasSRI tablasSRI = new TablasSRI();
		getForm().setListaTitulos(TXT_7_10);
		getForm()
				.setListaValores(tablasSRI.tabla4(getDatosGuiaRemision().getGuiaRemisionXML()
						.getDestinatarios()
						.getDestinatario()
						.get(i)
						.getCodDocSustento()),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getDestinatarios()
								.getDestinatario()
								.get(i)
								.getNumDocSustento(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getDestinatarios()
								.getDestinatario()
								.get(i)
								.getFechaEmisionDocSustento(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getDestinatarios()
								.getDestinatario()
								.get(i)
								.getNumAutDocSustento(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getDestinatarios()
								.getDestinatario()
								.get(i)
								.getMotivoTraslado());
		getForm()
				.setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
						Elemento.FORMATO_STRING,
						Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
		getForm().setListaDimensiones("25", "75");
		getForm().setListaPaneles("5");
	}

	/**
	 * Metodo para crear la informacion del cliente
	 *
	 */
	private void informacionDestinanario2(int i) {
		getForm().setListaTitulos(TXT_7_11);
		getForm()
				.setListaValores(getDatosGuiaRemision().getGuiaRemisionXML()
						.getDestinatarios()
						.getDestinatario()
						.get(i)
						.getRazonSocialDestinatario(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getDestinatarios()
								.getDestinatario()
								.get(i)
								.getIdentificacionDestinatario(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getDestinatarios()
								.getDestinatario()
								.get(i)
								.getDirDestinatario());
		getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
		getForm().setListaDimensiones("25", "75");
		getForm().setListaPaneles("3");
	}

	/**
	 * Metodo para crear la informacion del cliente
	 *
	 */
	private void informacionDestinanario3(int i) {
		getForm().setListaTitulos(TXT_7_12);
		getForm()
				.setListaValores(getDatosGuiaRemision().getGuiaRemisionXML()
						.getDestinatarios()
						.getDestinatario()
						.get(i)
						.getDocAduaneroUnico(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getDestinatarios()
								.getDestinatario()
								.get(i)
								.getCodEstabDestino(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getDestinatarios()
								.getDestinatario()
								.get(i)
								.getRuta());
		getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
		getForm().setListaDimensiones("25", "75");
		getForm().setListaPaneles("3");
	}

	/**
	 * Crea la tabla de envios a de mercader\u00eda de la guia de remisi\u00f3n.
	 *
	 * @param i
	 */
	private void informacionDetalleEnvio(int i) {
		List<Object> listaDatos = new ArrayList<>();

		for (Detalle a : getDatosGuiaRemision().getGuiaRemisionXML()
				.getDestinatarios()
				.getDestinatario()
				.get(i)
				.getDetalles()
				.getDetalle()) {

			List<String> listaValores = new ArrayList<>();
			listaValores.add(0, a.getCodigoInterno());
			listaValores.add(1, a.getCodigoAdicional());
			listaValores.add(2, a.getDescripcion());
			listaValores.add(3, String.valueOf(a.getCantidad()));
			listaDatos.add(listaValores);

			if (a.getDetallesAdicionales() != null
					&& !a.getDetallesAdicionales().getDetAdicional().isEmpty()) {
				for (Detalle.DetallesAdicionales.DetAdicional b : a.getDetallesAdicionales()
						.getDetAdicional()) {
					listaValores = new ArrayList<>();
					listaValores.add(0, "");
					listaValores.add(1, "");
					listaValores.add(2, b.getNombre() + ": " + b.getValor());
					listaValores.add(3, "");
					listaDatos.add(listaValores);
				}
			}
		}
		getTabla().setListaTitulos(TXT_7_2);
		getTabla()
				.setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
						Elemento.FORMATO_STRING,
						Elemento.FORMATO_STRING);
		getTabla().setListaDimensiones("15", "15", "60", "10");
		getTabla().setListaAlineacion(Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_LEFT,
				Element.ALIGN_RIGHT);
		getTabla().setListaDatos(listaDatos);
		getTabla().setAncho(100);
	}

	/**
	 * Metodo para informacion del transportista.
	 *
	 */
	private void informacionTransportista() {
		getForm().setListaTitulos(TXT_6_1);
		getForm()
				.setListaValores(getDatosGuiaRemision().getGuiaRemisionXML()
						.getInfoGuiaRemision()
						.getRazonSocialTransportista(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getInfoGuiaRemision()
								.getRucTransportista(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getInfoGuiaRemision()
								.getPlaca(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getInfoGuiaRemision()
								.getDirPartida(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getInfoGuiaRemision()
								.getFechaIniTransporte(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getInfoGuiaRemision()
								.getFechaFinTransporte(),
						getDatosGuiaRemision().getGuiaRemisionXML()
								.getInfoGuiaRemision()
								.getRise());
		getForm()
				.setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
						Elemento.FORMATO_STRING,
						Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
						Elemento.FORMATO_STRING,
						Elemento.FORMATO_STRING);
		getForm().setListaDimensiones("25", "75");
		getForm().setListaPaneles("8");
	}

	/**
	 * Metodo para agregar informaci\u00f3n adicional.
	 *
	 */
	@Override
	protected synchronized void elemento9() {
		int size = 0;

		if (getDatosGuiaRemision().getGuiaRemisionXML().getInfoAdicional() != null &&
				!getDatosGuiaRemision().getGuiaRemisionXML()
						.getInfoAdicional()
						.getCampoAdicional().isEmpty()) {

			for (GuiaRemision.InfoAdicional.CampoAdicional a : getDatosGuiaRemision().getGuiaRemisionXML()
					.getInfoAdicional()
					.getCampoAdicional()) {

				if (!a.getNombre().startsWith("js")) {
					getForm().getListaTitulos().add(a.getNombre());
					getForm().getListaValores().add(
							(a.getValue() == null) ? "" : String.valueOf(a.getValue()));
					getForm().getListaFormatos().add(Elemento.FORMATO_STRING);
					size++;
				}
			}

			if (size > 0) {

				int total = 74 + (12 * size);

				if (getPdfWriter().getVerticalPosition(true) < total)
					getDocumento().newPage();

				getElementosComunes().espacios(2);

				getH2().setTexto(TXT_10_1);
				getH2().escribe();
				getElementosComunes().espacios(2);

				getForm().setListaDimensiones("25", "75");
				getForm().setListaPaneles(String.valueOf(size));
				getForm().escribe();
			}
		}
	}

	public DatosGuiaRemision getDatosGuiaRemision() {
		return datosGuiaRemision;
	}

	public void setDatosGuiaRemision(DatosGuiaRemision datosGuiaRemision) {
		this.datosGuiaRemision = datosGuiaRemision;
	}
}