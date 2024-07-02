package biblioteca;

import java.util.Vector;

public class GestionBiblioteca {
	private GestionLibros gl=new GestionLibros();
	private GestionUsuarios gu=new GestionUsuarios();
	
	private Vector <Prestamo> prestamos=new Vector<Prestamo>();
	
	public void menu() {
		int opcion=0;
		do {
			System.out.println("Bienvenidos al Sistema de Gestion de Biblioteca");
			System.out.println("----------------------------------");
			System.out.println("1. Gestión de libros.");
			System.out.println("2. Gestión de usuarios.");
			System.out.println("3. Realizar préstamo.");
			System.out.println("4. Devolver préstamo.");
			System.out.println("5. Mostrar préstamos.");
			System.out.println("0. Salir.");
			opcion=PedirDatos.leerEntero("¿Qué desea hacer?");
			switch (opcion) {
			case 1:
				gestionLibros();
				break;
			case 2:
				gestionUsuarios();
				break;
			case 3:
				realizarPrestamo();
				break;
			case 4:
				devolverPrestamo();
				break;
			case 5:
				mostrarPrestamos();
				break;
			case 0:
				System.out.println("¡Adiós!");
				break;
			default:
				System.out.println("Debe introducir una opción entre 0 y 5.");

				break;
			}
		} while (opcion!=0);
	}

	private void gestionLibros() {
		gl.menu();
	}

	private void gestionUsuarios() {
		gu.menu();
	}
	
	public void realizarPrestamo() {
		long codusuario=PedirDatos.leerLong("Introduzca el código del usuario que desea solicitar un préstamo.");
		int pos=gu.buscarUsuario(codusuario);
		if (pos==-1) {
			System.out.println("El usuario con el código "+codusuario+" no existe.");
			return;
		}
		char tipomaterial=PedirDatos.leerCaracter("Introduzca el tipo de material que desea. (L = Libro)");

		while (tipomaterial!='L'&&tipomaterial!='R'&&tipomaterial!='C') {
			tipomaterial=PedirDatos.leerCaracter("Valor incorrecto. Introduzca el tipo de material que desea. (L = Libro)");			

		}
		long codmaterial=0;
		switch (tipomaterial) {
		case 'L':
			codmaterial=PedirDatos.leerLong("Introduzca el ISBN del libro que desea sacar.");
			pos=gl.buscarLibro(codmaterial);
			if (pos==-1) {
				System.out.println("El libro con el ISBN "+codmaterial+" no existe.");
				return;
			}
			break;
		}
		if (buscarPrestamo(tipomaterial, codmaterial)!=-1) {
			System.out.println("El material que desea pedir se encuentra prestado actualmente.");
			return;
		}
		String fechaprestamo=PedirDatos.leerCadena("Introduzca la fecha del préstamo (DD/MM/AAAA).");
		Prestamo p=new Prestamo(codusuario, tipomaterial, codmaterial, fechaprestamo);
		this.prestamos.addElement(p);
		System.out.println("Préstamo realizado correctamente.");
	}
	
	public void devolverPrestamo() {
		if (this.prestamos.isEmpty()) {
			System.out.println("No se pueden devolver préstamos porque todavía no se ha realizado ninguno.");
			return;
		}
		long codusuario=PedirDatos.leerLong("Introduzca el código de usuario que realizó el préstamo.");
		char tipomaterial=PedirDatos.leerCaracter("Introduzca el tipo de material que se prestó.");
		long codmaterial=PedirDatos.leerLong("Introduzca el código del material que se prestó.");
		int pos=buscarPrestamo(codusuario, tipomaterial, codmaterial);
		if (pos==-1) {
			System.out.println("No existe ningún préstamo con los datos introducidos.");
			return;
		}
		String fechadevolucion=PedirDatos.leerCadena("Introduzca la fecha de devolución (DD/MM/AAAA).");
		this.prestamos.elementAt(pos).setFechadevolucion(fechadevolucion);
		System.out.println("Se ha devuelto el siguiente préstamo:\nCódigo del préstamo: "+(pos+1)+"\n"+this.prestamos.elementAt(pos));
	}
	
	public void mostrarPrestamos() {
		for (int i = 0; i < this.prestamos.size(); i++) {
			System.out.println(this.prestamos.elementAt(i));
			System.out.println("-------------------------");
		}
	}
	
	//Método de búsqueda para los préstamos
	private int buscarPrestamo(char tipomaterial, long codmaterial) {
		for (int i = 0; i < this.prestamos.size(); i++) {
			if (tipomaterial==this.prestamos.elementAt(i).getTipomaterial()&&codmaterial==this.prestamos.elementAt(i).getCodmaterial()) {
				return i;
			}
		}
		return -1;
	}
	
	//Método de búsqueda para las devoluciones
	private int buscarPrestamo(long codusuario, char tipomaterial, long codmaterial) {
		for (int i = 0; i < this.prestamos.size(); i++) {
			if (codusuario==this.prestamos.elementAt(i).getCodusuario()&&tipomaterial==this.prestamos.elementAt(i).getTipomaterial()&&
					codmaterial==this.prestamos.elementAt(i).getCodmaterial()) {
				return i;
			}
		}
		return -1;
	}
}
