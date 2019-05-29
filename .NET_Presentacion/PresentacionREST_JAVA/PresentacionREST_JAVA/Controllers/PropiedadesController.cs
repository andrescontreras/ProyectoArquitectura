using PresentacionREST_JAVA.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;

namespace PresentacionREST_JAVA.Controllers
{
    public class PropiedadesController : Controller
    {
		string Baseurl = "http://localhost:8080/OPR/webresources/entities.propiedad";

		// GET: Propiedades
		public ActionResult Index(string buscarPor, string buscar)
        {
			if (buscarPor == "cedula" && buscar != "")
			{
				IEnumerable<PropiedadDTO> propiedades = null;

				using (var client = new HttpClient())
				{
					client.BaseAddress = new Uri(Baseurl);
					//HTTP GET
					var responseTask = client.GetAsync("entities.propiedad/cedula/"+buscar);
					responseTask.Wait();

					var result = responseTask.Result;
					if (result.IsSuccessStatusCode)
					{
						var readTask = result.Content.ReadAsAsync<IList<PropiedadDTO>>();
						readTask.Wait();

						propiedades = readTask.Result;
					}
					else //web api sent error response 
					{
						//log response status here..

						propiedades = Enumerable.Empty<PropiedadDTO>();

						ModelState.AddModelError(string.Empty, "Server error. Please contact administrator.");
					}
				}
				return View(propiedades);
			}
			else if (buscarPor == "nombre" && buscar != "")
			{
				IEnumerable<PropiedadDTO> propiedades = null;

				using (var client = new HttpClient())
				{
					client.BaseAddress = new Uri(Baseurl);
					//HTTP GET
					var responseTask = client.GetAsync("entities.propiedad/nombre/"+buscar);
					responseTask.Wait();

					var result = responseTask.Result;
					if (result.IsSuccessStatusCode)
					{
						var readTask = result.Content.ReadAsAsync<IList<PropiedadDTO>>();
						readTask.Wait();

						propiedades = readTask.Result;
					}
					else //web api sent error response 
					{
						//log response status here..

						propiedades = Enumerable.Empty<PropiedadDTO>();

						ModelState.AddModelError(string.Empty, "Server error. Please contact administrator.");
					}
				}
				return View(propiedades);
			}
			else {
				IEnumerable<PropiedadDTO> propiedades = null;

				using (var client = new HttpClient())
				{
					client.BaseAddress = new Uri(Baseurl);
					//HTTP GET
					var responseTask = client.GetAsync("entities.propiedad");
					responseTask.Wait();

					var result = responseTask.Result;
					if (result.IsSuccessStatusCode)
					{
						var readTask = result.Content.ReadAsAsync<IList<PropiedadDTO>>();
						readTask.Wait();

						propiedades = readTask.Result;
					}
					else //web api sent error response 
					{
						//log response status here..

						propiedades = Enumerable.Empty<PropiedadDTO>();

						ModelState.AddModelError(string.Empty, "Server error. Please contact administrator.");
					}
				}
				return View(propiedades);
			}
	
			
		}

        // GET: Propiedades/Details/5
        public ActionResult Details(int id)
        {
			PropiedadDTO propiedad = null;

			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);
				//HTTP GET
				var responseTask = client.GetAsync("entities.propiedad/" + id);
				responseTask.Wait();

				var result = responseTask.Result;
				if (result.IsSuccessStatusCode)
				{
					var readTask = result.Content.ReadAsAsync<PropiedadDTO>();
					readTask.Wait();

					propiedad = readTask.Result;
				}
				else //web api sent error response 
				{
					//log response status here..

					propiedad = new PropiedadDTO();

					ModelState.AddModelError(string.Empty, "Server error. Please contact administrator.");
				}
			}
			return View(propiedad);
		}

        // GET: Propiedades/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Propiedades/Create
        [HttpPost]
        public ActionResult Create(PropiedadDTO propiedad)
        {
			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);

				//HTTP POST
				var postTask = client.PostAsJsonAsync("entities.propiedad", propiedad);
				postTask.Wait();

				var result = postTask.Result;
				if (result.IsSuccessStatusCode)
				{
					return RedirectToAction("Index");
				}
			}

			ModelState.AddModelError(string.Empty, "Server Error. Please contact administrator.");

			return View(propiedad);
		}

        // GET: Propiedades/Edit/5
        public ActionResult Edit(int id)
        {
			PropiedadDTO propiedad = null;

			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);
				//HTTP GET
				var responseTask = client.GetAsync("entities.propiedad/" + id);
				responseTask.Wait();

				var result = responseTask.Result;
				if (result.IsSuccessStatusCode)
				{
					var readTask = result.Content.ReadAsAsync<PropiedadDTO>();
					readTask.Wait();

					propiedad = readTask.Result;
				}
			}
			return View(propiedad);
		}

        // POST: Propiedades/Edit/5
        [HttpPost]
        public ActionResult Edit(PropiedadDTO propiedad)
        {
			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);

				//HTTP POST
				var putTask = client.PutAsJsonAsync("entities.propiedad", propiedad);
				putTask.Wait();

				var result = putTask.Result;
				if (result.IsSuccessStatusCode)
				{

					return RedirectToAction("Index");
				}
			}
			return View(propiedad);
		}

        // GET: Propiedades/Delete/5
        public ActionResult Delete(int id)
        {
			PropiedadDTO propiedad = null;

			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);
				//HTTP GET
				var responseTask = client.GetAsync("entities.propiedad/" + id);
				responseTask.Wait();

				var result = responseTask.Result;
				if (result.IsSuccessStatusCode)
				{
					var readTask = result.Content.ReadAsAsync<PropiedadDTO>();
					readTask.Wait();

					propiedad = readTask.Result;
				}
			}
			return View(propiedad);
		}

        // POST: Propiedades/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);

				//HTTP POST
				var putTask = client.DeleteAsync("entities.propiedad/" + id);
				putTask.Wait();

				var result = putTask.Result;
				if (result.IsSuccessStatusCode)
				{

					return RedirectToAction("Index");
				}
			}
			return View();
		}


    }
}
