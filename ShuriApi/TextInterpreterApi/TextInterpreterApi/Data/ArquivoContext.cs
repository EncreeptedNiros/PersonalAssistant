using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations.Schema;
using TextInterpreterApi.Models;

namespace TextInterpreterApi.Data
{
    [Table("Arquivo")]
    public class ArquivoContext : DbContext
    {
        public ArquivoContext(DbContextOptions<ArquivoContext> opts) : base(opts)
        {
        }
        public DbSet<Arquivo> Arquivos { get; set; }
    }
}
