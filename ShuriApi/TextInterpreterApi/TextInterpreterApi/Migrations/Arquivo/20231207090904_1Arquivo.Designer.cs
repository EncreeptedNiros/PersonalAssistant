﻿// <auto-generated />
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using TextInterpreterApi.Data;

#nullable disable

namespace TextInterpreterApi.Migrations.Arquivo
{
    [DbContext(typeof(ArquivoContext))]
    [Migration("20231207090904_1Arquivo")]
    partial class _1Arquivo
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "6.0.11")
                .HasAnnotation("Relational:MaxIdentifierLength", 64);

            modelBuilder.Entity("TextInterpreterApi.Models.Arquivo", b =>
                {
                    b.Property<string>("URL")
                        .HasColumnType("varchar(255)");

                    b.Property<string>("nome")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("tipo")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.HasKey("URL");

                    b.ToTable("Arquivos");
                });
#pragma warning restore 612, 618
        }
    }
}