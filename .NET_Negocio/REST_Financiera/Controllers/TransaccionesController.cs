using LogicaFinanciera.Negocio;
using LogicaFinanciera.SideCar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Results;

namespace REST_Financiera.Controllers
{
    public class TransaccionesController : ApiController
    {
		private FacadeTransacciones ft = new FacadeTransacciones();
		// GET: api/Transacciones
		public List<TransaccionDTO> Get()
        {
			List<TransaccionDTO> transaccionDTOs = new List<TransaccionDTO>();
			TransaccionDTO t = new TransaccionDTO();
			t.tipoDocumento = "c.c";
			t.numDocumento = 123456;
			t.password = "password";
			t.descontar = 50000;
			transaccionDTOs.Add(t);
			TransaccionDTO t1 = new TransaccionDTO();
			t1.tipoDocumento = "c.c";
			t1.numDocumento = 123456;
			t1.password = "password";
			t1.descontar = 50000;
			transaccionDTOs.Add(t1);
			TransaccionDTO t2 = new TransaccionDTO();
			t2.tipoDocumento = "c.c";
			t2.numDocumento = 123456;
			t2.password = "password";
			t2.descontar = 50000;
			transaccionDTOs.Add(t2);
			return transaccionDTOs;
		}

        // GET: api/Transacciones/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Transacciones
        public object Post(TransaccionDTO transaccionDTO)
        {
			return Ok( ft.pagarRenta(transaccionDTO));
        }

        // PUT: api/Transacciones/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Transacciones/5
        public void Delete(int id)
        {
        }
    }
}
