using LogicaFinanciera.SideCar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LogicaFinanciera.Negocio
{
	public class FacadeTransacciones
	{
		public AprobacionDTO pagarRenta(TransaccionDTO transaccionDTO) {
			int estado = new FacadeUsuarios().PagarRenta(transaccionDTO);
			if (estado > 0)
			{
				return new FacadeMovimientos().generarMovimientoExitoso(estado, transaccionDTO.monto);
			}

			AprobacionDTO aprobacionDTO = new AprobacionDTO();
			aprobacionDTO.estado = estado == -2 ? 1 : 0;
			aprobacionDTO.numAProvacion = -1;
			aprobacionDTO.fechaAprovacion = DateTime.Now;
			return aprobacionDTO;
		}

	}
}