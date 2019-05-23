using PresentacionREST.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;

namespace PresentacionREST.Controllers
{
    public class UsuariosController : Controller
    {
        // url
		string Baseurl = "http://localhost:8081/api/Usuarios";
		// GET: Usuarios
		public ActionResult Index()
        {
			IEnumerable<UsuarioDTO> usuarios = null;

			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);
				//HTTP GET
				var responseTask = client.GetAsync("Usuarios");
				responseTask.Wait();

				var result = responseTask.Result;
				if (result.IsSuccessStatusCode)
				{
					var readTask = result.Content.ReadAsAsync<IList<UsuarioDTO>>();
					readTask.Wait();

					usuarios = readTask.Result;
				}
				else //web api sent error response 
				{
					//log response status here..

					usuarios = Enumerable.Empty<UsuarioDTO>();

					ModelState.AddModelError(string.Empty, "Server error. Please contact administrator.");
				}
			}
			return View(usuarios);
		}

        // GET: Usuarios/Details/5
        public ActionResult Details(int id)
        {
			UsuarioDTO usuario = null;

			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);
				//HTTP GET
				var responseTask = client.GetAsync("Usuarios/"+id);
				responseTask.Wait();

				var result = responseTask.Result;
				if (result.IsSuccessStatusCode)
				{
					var readTask = result.Content.ReadAsAsync<UsuarioDTO>();
					readTask.Wait();

					usuario = readTask.Result;
				}
				else //web api sent error response 
				{
					//log response status here..

					usuario = new UsuarioDTO();

					ModelState.AddModelError(string.Empty, "Server error. Please contact administrator.");
				}
			}
			return View(usuario);
		}

        // GET: Usuarios/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Usuarios/Create
        [HttpPost]
        public ActionResult Create(UsuarioDTO usuario)
        {
			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);

				//HTTP POST
				var postTask = client.PostAsJsonAsync("Usuarios", usuario);
				postTask.Wait();

				var result = postTask.Result;
				if (result.IsSuccessStatusCode)
				{
					return RedirectToAction("Index");
				}
			}

			ModelState.AddModelError(string.Empty, "Server Error. Please contact administrator.");

			return View(usuario);
		}

        // GET: Usuarios/Edit/5
        public ActionResult Edit(int id)
        {
			UsuarioDTO student = null;

			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);
				//HTTP GET
				var responseTask = client.GetAsync("Usuarios/" + id);
				responseTask.Wait();

				var result = responseTask.Result;
				if (result.IsSuccessStatusCode)
				{
					var readTask = result.Content.ReadAsAsync<UsuarioDTO>();
					readTask.Wait();

					student = readTask.Result;
				}
			}
			return View(student);
		}

        // POST: Usuarios/Edit/5
        [HttpPost]
        public ActionResult Edit(UsuarioDTO usuario)
        {
			using (var client = new HttpClient())
			{
				client.BaseAddress = new Uri(Baseurl);

				//HTTP POST
				var putTask = client.PutAsJsonAsync("Usuarios", usuario);
				putTask.Wait();

				var result = putTask.Result;
				if (result.IsSuccessStatusCode)
				{

					return RedirectToAction("Index");
				}
			}
			return View(usuario);
		}

        // GET: Usuarios/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Usuarios/Delete/5
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
