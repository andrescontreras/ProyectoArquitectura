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

namespace REST_Financiera.Controllers
{
    public class MovimientosController : ApiController
    {
        private FinancieraEntities db = new FinancieraEntities();

        // GET: api/Movimientos
        public IQueryable<Movimiento> GetMovimiento()
        {
            return db.Movimiento;
        }

        // GET: api/Movimientos/5
        [ResponseType(typeof(Movimiento))]
        public IHttpActionResult GetMovimiento(decimal id)
        {
            Movimiento movimiento = db.Movimiento.Find(id);
            if (movimiento == null)
            {
                return NotFound();
            }

            return Ok(movimiento);
        }

        // PUT: api/Movimientos/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutMovimiento(decimal id, Movimiento movimiento)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != movimiento.id_movimiento)
            {
                return BadRequest();
            }

            db.Entry(movimiento).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!MovimientoExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Movimientos
        [ResponseType(typeof(Movimiento))]
        public IHttpActionResult PostMovimiento(Movimiento movimiento)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Movimiento.Add(movimiento);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = movimiento.id_movimiento }, movimiento);
        }

        // DELETE: api/Movimientos/5
        [ResponseType(typeof(Movimiento))]
        public IHttpActionResult DeleteMovimiento(decimal id)
        {
            Movimiento movimiento = db.Movimiento.Find(id);
            if (movimiento == null)
            {
                return NotFound();
            }

            db.Movimiento.Remove(movimiento);
            db.SaveChanges();

            return Ok(movimiento);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool MovimientoExists(decimal id)
        {
            return db.Movimiento.Count(e => e.id_movimiento == id) > 0;
        }
    }
}