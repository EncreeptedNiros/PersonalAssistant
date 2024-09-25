using TextInterpreterApi.Models;
using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations.Schema;

namespace TextInterpreterApi.Data
{
    [Table("Agenda")]
    public class AgendaContext : DbContext
    {
        public AgendaContext(DbContextOptions<AgendaContext> opts) : base(opts)
        {
        }
        public DbSet<Agenda> Agendas { get; set; }
    }
}
