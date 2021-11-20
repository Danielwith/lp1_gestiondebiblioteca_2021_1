package util;

public class Validaciones {
	public static final String TEXTO = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,20}";
	public static final String DNI = "[0-9]{8}";
	public static final String NUM_HIJOS = "[0-9]|[1][0]";
	public static final String SUELDO = "(\\d+)|(\\d+[.]\\d{1,2})";
	public static final String PREMIO = "(\\d+)|(\\d+[.]\\d{1})";
	public static final String PLACA = "[A-Z]{2}\\d{4}";
	public static final String STOCK = "\\d+";
	public static final String FECHA = "((19|20)\\d\\d)[-/](0?[1-9]|1[012])[-/](0?[1-9]|[12][0-9]|3[01])";
	public static final String FECHAREGISTRO = "((19|20)\\d\\d)[-/](0?[1-9]|1[012])[-/](0?[1-9]|[12][0-9]|3[01])\\s(([0-9]{2})[:]([0-6][0-9])[:]([0-6][0-9]))";
	public static final String CORREO = "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})"; 
	public static final String SEDE = "\\d{1,2}";
	public static final String ANNO = "\\d{4}";
	public static final String RUC = "\\d{11}";
	public static final String ISO = "[A-Z]{2}";
	public static final String SERIE="[0-9]{1}";
	public static final String PRECIO="\\d+.\\d";
	public static final String TEXTO_NUMERO = "[0-9a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,40}";
	public static final String NUMERO = "[0-9]{1,1000}";
	public static final String SERIECRUDLIBRO= "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,100}";

	
	//Validaciones para Registro Alumno//
	public static final String TEXTOALUMNO = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,30}";
	public static final String TEXTOPROV = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{1,20}";
	

}
