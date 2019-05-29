using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using LogicaFinanciera;
using LogicaFinanciera.Negocio;

namespace REST_Financiera.Controllers
{
    public class MovimientosController : ApiController
    {
		private FacadeMovimientos fm = new FacadeMovimientos();

		// GET: api/Movimientos
		public List<Movimiento> GetMovimiento()
        {
			return fm.GetMovimientos();
		}

        // GET: api/Movimientos/5
        [ResponseType(typeof(Movimiento))]
        public IHttpActionResult GetMovimiento(int id)
        {
            Movimiento movimiento = fm.GetMovimiento(id);
            if (movimiento == null)
            {
                return NotFound();
            }

            return Ok(movimiento);
        }

        // PUT: api/Movimientos/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutMovimiento(Movimiento movimiento)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

			Movimiento rmovimiento = fm.EditMovimiento(movimiento);

			if (rmovimiento == null)
			{
				return NotFound();
			}

			return Ok(rmovimiento);
        }

        // POST: api/Movimientos
        [ResponseType(typeof(Movimiento))]
        public IHttpActionResult PostMovimiento(Movimiento movimiento)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

			Movimiento rmovimiento = fm.AddMovimiento(movimiento);

			if (rmovimiento == null)
			{
				return NotFound();
			}

			return Ok(rmovimiento);
		}

        // DELETE: api/Movimientos/5
        [ResponseType(typeof(Movimiento))]
        public IHttpActionResult DeleteMovimiento(int id)
        {
			Movimiento rmovimiento = fm.DeleteMovimiento(id);
			if (rmovimiento == null)
			{
				return NotFound();
			}

			return Ok(rmovimiento);
		}
    }
}