using Microsoft.AspNetCore.Mvc;
using TextInterpreterApi.Data;
using TextInterpreterApi.Models;

namespace TextInterpreterApi.Controllers;


[ApiController]
[Microsoft.AspNetCore.Mvc.Route("[controller]")]
public class ResponseController : ControllerBase
{
    private ResponseContext _context;
    public ResponseController(ResponseContext context)
    {
        _context = context;
    }

    [HttpPost]
    public void ReciveText([FromBody] Response response)
    {
        _context.Responses.Add(response);
        _context.SaveChanges();
        //Console.WriteLine(response.Id);
        //Console.WriteLine(response.responsetext);
    }
    [HttpGet("{id}")]
    public IActionResult ReturnText(int id) 
    {
        var response = _context.Responses.FirstOrDefault(response => response.Id == id);
        if (response == null) 
        {
            return NotFound();
        }
        return Ok(response);
    }
    [HttpGet]
    public IEnumerable<Response> PagText([FromQuery] int skip = 0, [FromQuery] int take = 5)
    {
        return _context.Responses.Skip(skip).Take(take);
    }
}
