using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PresentacionREST.Models
{
	public class MovimientoDTO
	{
		public int id_movimiento { get; set; }
		public int? num_aprovacion { get; set; }
		public int valor { get; set; }
		public System.DateTime fecha { get; set; }
		public bool estado { get; set; }
		public int id_usuario { get; set; }

		public virtual UsuarioDTO Usuario { get; set; }
	}
}