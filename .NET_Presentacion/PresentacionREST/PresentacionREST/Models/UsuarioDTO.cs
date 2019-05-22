using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PresentacionREST.Models
{
	public class UsuarioDTO
	{
		public decimal id_usuario { get; set; }
		public string nombre { get; set; }
		public string password { get; set; }
		public string tipo_documento { get; set; }
		public decimal numero_documento { get; set; }
		public decimal saldo { get; set; }

		[System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
		public virtual ICollection<MovimientoDTO> Movimiento { get; set; }
	}
}