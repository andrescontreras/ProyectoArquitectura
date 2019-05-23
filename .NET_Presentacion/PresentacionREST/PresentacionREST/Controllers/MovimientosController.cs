using PresentacionREST.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;

namespace PresentacionREST.Controllers
{
    public class MovimientosController : Controller
    {
		string Baseurl = "http://localhost:8081/api/Movimientos";
		// GET: Movimientos
		public ActionResult Index()
        {
			IEnumerable<MovimientoDTO> movimientos = null;

			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);
				//HTTP GET
				var responseTask = client.GetAsync("Usuarios");
				responseTask.Wait();

				var result = responseTask.Result;
				if (result.IsSuccessStatusCode)
				{
					var readTask = result.Content.ReadAsAsync<IList<MovimientoDTO>>();
					readTask.Wait();

					movimientos = readTask.Result;
				}
				else //web api sent error response 
				{
					//log response status here..

					movimientos = Enumerable.Empty<MovimientoDTO>();

					ModelState.AddModelError(string.Empty, "Server error. Please contact administrator.");
				}
			}
			return View(movimientos);
		}

        // GET: Movimientos/Details/5
        public ActionResult Details(int id)
        {
            return View();
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
