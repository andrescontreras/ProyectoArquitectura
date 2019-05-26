using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PresentacionREST_JAVA.Models
{
	public class PropiedadDTO
	{
		public int id { get; set; }
		public string nombreOwner { get; set; }
		public int cedulaOwner { get; set; }
		public string nombre { get; set; }
		public string descripcion { get; set; }
		public string tipoCedula { get; set; }
		public string tipo { get; set; }
		public string direccion { get; set; }
		public string localidad { get; set; }
		public int numCuartos { get; set; }
		public int precio { get; set; }
		public bool tentada { get; set; }
	}
}