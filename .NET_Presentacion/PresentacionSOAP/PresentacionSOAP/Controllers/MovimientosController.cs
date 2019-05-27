using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace PresentacionSOAP.Controllers
{
    public class MovimientosController : Controller
    {
        // GET: Movimientos
        public ActionResult Index()
        {
            return View();
        }

		public ActionResult List()
		{
			ProxyMovimientos.WSMovimientosClient proxy = new ProxyMovimientos.WSMovimientosClient();
			ProxyMovimientos.Movimiento[] movimientos = proxy.GetAllMovimiento();
			return View(movimientos.ToList());
		}

		// GET: Movimientos/Details/5
		public ActionResult Details(int id)
        {
			ProxyMovimientos.WSMovimientosClient proxy = new ProxyMovimientos.WSMovimientosClient();
			ProxyMovimientos.Movimiento movimiento = proxy.GetAllMovimientoById(id);
			return View(movimiento);
		}

        // GET: Movimientos/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Movimientos/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Movimientos/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Movimientos/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Movimientos/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Movimientos/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
