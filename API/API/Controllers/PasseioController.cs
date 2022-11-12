using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using API.Models;

namespace API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PasseioController : ControllerBase
    {
        private readonly PasseioDbContext _context;

        public PasseioController(PasseioDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<Passeio> GetPasseioS()
        {
            return _context.PasseioS;
        }

        [HttpGet("{id}")]
        public IActionResult GetPasseioById(int id)
        {
            Passeio passeio = _context.Passeios.SingleOrDefault(modelo => modelo.id == id);
            if (Passeio == null)
            {
                return NotFound();
            }
            return new ObjectResult(passeio);
        }

        // CRIA uma nova Viagem
        [HttpPost]
        public IActionResult CreatePasseio(Passeio item)
        {
            if (item == null)
            {
                return BadRequest();
            }



            _context.Passeios.Add(item);
            _context.SaveChanges();
            return new ObjectResult(item);

        }

        // ATUALIZA UMa Viagem EXISTENTE
        [HttpPut("{id}")] updatePasseio(int id, Passeio item)
        {
            if (id != item.id)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();



            return new NoContentResult();
        }

        // APAGA UMa Viagem POR ID
        [HttpDelete("{id}")]
        public IActionResult DeletePasseio(int id)
        {
            var passeio = _context.Passeios.SingleOrDefault(m => m.id == id);



            if (passeio == null)
            {
                return BadRequest();
            }



            _context.Passeios.Remove(viagem);
            _context.SaveChanges();
            return Ok(passeio);
        }
    }
}
