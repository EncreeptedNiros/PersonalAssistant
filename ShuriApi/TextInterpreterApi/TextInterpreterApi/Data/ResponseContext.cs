using TextInterpreterApi.Models;
using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations.Schema;

namespace TextInterpreterApi.Data
{
    [Table("Response")]
    public class ResponseContext : DbContext
    {
        public ResponseContext(DbContextOptions<ResponseContext> opts) : base(opts)
        {
        }
        public DbSet<Response> Responses { get; set; }
    }
}
