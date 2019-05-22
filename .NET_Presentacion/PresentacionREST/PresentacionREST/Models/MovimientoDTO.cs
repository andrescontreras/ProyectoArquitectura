using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PresentacionREST.Models
{
	public class MovimientoDTO
	{
		public decimal id_movimiento { get; set; }
		public Nullable<decimal> num_aprovacion { get; set; }
		public decimal valor { get; set; }
		public System.DateTime fecha { get; set; }
		public bool estado { get; set; }
		public decimal id_usuario { get; set; }

		public virtual UsuarioDTO Usuario { get; set; }
	}
}