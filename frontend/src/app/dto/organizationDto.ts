import {OrganizationTagDto} from './OrganizationTagDto';

export class OrganizationDto {
  id: number;
  name: string;
  website: string;
  partnerIds: number[];
  organizationTags: OrganizationTagDto[];

  constructor(id: number, name: string, website: string, partnerIds: number[], tags: OrganizationTagDto[]) {
    this.id = id;
    this.name = name;
    this.website = website;
    this.partnerIds = partnerIds;
    this.organizationTags = tags;
  }
}
